/**
 * The SentenceProcessor provides methods to remove duplicated words and replace a word with another
 */
public class SentenceProcessor {
	/**
	 * Convert the sentence into a word matrix
	 * Use for loops to detect the duplicated word and reconstruct the sentence without the duplicated word
	 * 
	 * @param sentence the original sentence
	 * @return the sentence with duplicated words removed 
	 */
	public String removeDuplicatedWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        String[] seen = new String[words.length];
        int count = 0;
        String result = "";

        for (String word : words) {
            boolean isDuplicate = false;

            // Check if this word has already been seen
            for (int i = 0; i < count; i++) {
                if (seen[i].equals(word)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                seen[count++] = word;
                result += word + " ";
            }
        }

        return result.trim();
    }
	/**
	 * Convert the sentence into a word matrix
	 * Use for loops to detect the target and reconstruct the sentence with the replacement
	 * 
	 * @param target the word to be replaced
	 * @param replacement the word to replace with
	 * @param sentence the original sentence
	 * @return the sentence with the target replaced
	 */
	public String replaceWord(String target, String replacement, String sentence) {
        String[] words = sentence.trim().split("\\s+");
        String result = "";

        for (String word : words) {
            if (word.equals(target)) {
                result += replacement + " ";
            } else {
                result += word + " ";
            }
        }

        return result.trim();
    }
	/**
	 * Main method to test the removeDuplicatedWords and replaceWord methods
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
        SentenceProcessor sp = new SentenceProcessor();

        System.out.println(sp.removeDuplicatedWords("Hello Hello World I love love the World I lovelove the World"));
        System.out.println(sp.removeDuplicatedWords("Buffalo buffalo Buffalo buffalo buffalo buffalo Buffalo buffalo"));
        System.out.println(sp.removeDuplicatedWords("a a la a la carte A la La carte Carte A a la la"));

        System.out.println(sp.replaceWord("major", "minor", "The major problem is how to sing in A major"));
        System.out.println(sp.replaceWord("on", "off", "Turn on the television I want to keep the television on"));
        System.out.println(sp.replaceWord("love", "hate", "I love the World I lovelove the Love"));
    }
}

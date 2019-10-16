package bartek;

public class Cezar {

    private static char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZA".toCharArray();

    Cezar() {

    }

    /***
     * wykonuje szyfrowanie za pomoca szyfru cezara
     * @param input tekst do zaszyfrowania
     * @return zaszyfrowany tekst
     */

    public String cypher(final String input) {
        char[] output;
        output = input.toCharArray();
        for (int i = 0; i < output.length; i++) {
            int index = 0;
            if (output[i] != ' ') {
                while (output[i] != letters[index]) {
                    index++;
                }
                output[i] = letters[index + 1];
            }
        }
        //return output.toString();
        //final String result = new String(output);
        return new String(output);
    }
}
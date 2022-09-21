package exercise;

// BEGIN
public final class ReversedSequence implements CharSequence {

    private final String text;
    private final String reversedText;

    public ReversedSequence(String text) {
        this.text = text;
        reversedText = new StringBuilder(text).reverse().toString();
    }

    @Override
    public String toString() {
        return reversedText;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return reversedText.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reversedText.substring(start, end);
    }
    public String getText() {
        return text;
    }
}
// END

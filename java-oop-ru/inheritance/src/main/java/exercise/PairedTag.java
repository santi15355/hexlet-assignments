package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<")
                .append(getName())
                .append(attributesToString())
                .append(">")
                .append(body);
        for (Tag tag : children) {
            sb.append(tag);
        }
        sb.append("</")
                .append(getName())
                .append(">");

        return sb.toString();
    }
}
// END

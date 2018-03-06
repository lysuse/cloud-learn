import java.util.ArrayList;
import java.util.List;

public class TestFieldList {

    public static void main(String[] args) {
        String field = "user.roles[1].name";
        List<String> fieldList = new ArrayList<>();
        buildFieldList(field, fieldList);

        System.out.println(fieldList);
    }

    public static void buildFieldList(String field, List<String> fieldList) {
        fieldList.add(field);
        String plainField = field;
        int keyIndex = field.lastIndexOf(91);

        while(keyIndex != -1) {
            int endKeyIndex = plainField.indexOf(93, keyIndex);
            if (endKeyIndex != -1) {
                plainField = plainField.substring(0, keyIndex) + plainField.substring(endKeyIndex + 1);
                fieldList.add(plainField);
                keyIndex = plainField.lastIndexOf(91);
            } else {
                keyIndex = -1;
            }
        }

    }

}

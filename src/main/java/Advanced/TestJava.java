package Advanced;

public class TestJava {

    public static void main(String[] args) {
        String s = "Please email us at mentor@rahulshettyacademy.com with below template to receive response";
        String arr[] = s.split("at");
        String[] emailArr = arr[1].trim().split(" ");
        String email = emailArr[0];
        System.out.println(email);
    }
}

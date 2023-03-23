public class EmployeeInfo {
    int name;


    private final String accessCode;


    public EmployeeInfo() {

        String accessCode1 = new String();
        this.accessCode = accessCode1;
    }


    public String getAccessCode() {
        return null;
    }

    public String getName() {
        return null;
    }
    public EmployeeInfo(String name, String accessCode) {
        this.name = Integer.parseInt(name);
        this.accessCode = accessCode;
    }
}

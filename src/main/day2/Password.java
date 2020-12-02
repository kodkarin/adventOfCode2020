package day2;

public class Password {

    private String password;
    private Policy policy;

    public Password(String passwordWithPolicy) {
        setPasswordAndPolicy(passwordWithPolicy);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    private void setPasswordAndPolicy(String inputString) {
        String[] parts = inputString.split(":");
        setPolicy(new Policy(parts[0].trim()));
        setPassword(parts[1].trim());
    }
}

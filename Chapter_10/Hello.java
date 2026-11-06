public class Hello {
    private int i;
    private int j;

    public void gi() {
        // ...
        if (someCondition()) {
            f();
        }
        // ...
    }

    private void f() {
        i++;
        j++;
    }

    private boolean someCondition() {
        return true; // example condition
    }

    public static void main(String[] args) {
        Hello gi = new Hello();
        gi.gi();
        System.out.println("i=" + gi.i + ", j=" + gi.j);
    }
}

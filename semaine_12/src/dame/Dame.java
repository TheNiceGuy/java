package dame;

import dame.DameFrame;

public class Dame {
    public static void main(String[] args) {
        DameFrame dame = new DameFrame();

        dame.init();
        dame.createWindow();
        dame.selectPlayerMovement();
        dame.showWindow();
    }
}

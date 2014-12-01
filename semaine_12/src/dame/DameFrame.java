package dame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

public class DameFrame implements ActionListener {
    final private String NOM = "MLG Dame";
    final private int X   = 8;
    final private int Y   = 8;
    final private int BL  = 0;
    final private int S[] = { X, Y};
    final private int P[] = {-1, 1};

    private GridLayout grid    = new GridLayout(X, Y);
    private JFrame frame       = new JFrame(NOM);
    private JPanel content     = new JPanel(grid);
    private JButton button[][] = new JButton[X][Y];

    private boolean isSelection = false;
    private int state[][]   = new int[X][Y];
    private int playerTurn  = 0;
    private int selection[] = new int[2];
    private int lastToken[] = new int[2];

    private String iconToken[] = new String[2];

    public DameFrame() {
    }

    public void init() {
        int i, j;

        iconToken[0] = "img/doritos_50x50.png";
        iconToken[1] = "img/dew_50x50.png";

        for(i = 0; i < X; i++)
            for(j = 0; j < Y; j++) {
                switch(i) {
                case 0:
                case 2:
                    if(j%2 == 0)
                        state[i][j] = P[0];
                    break;
                case 1:
                    if(j%2 == 1)
                        state[i][j] = P[0];
                    break;

                case Y-1:
                case Y-3:
                    if(j%2 == 1)
                        state[i][j] = P[1];
                    break;
                case Y-2:
                    if(j%2 == 0)
                        state[i][j] = P[1];
                    break;
                default:
                    state[i][j] = BL;
                }
            }
    }

    public void createWindow() {
        int i, j;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(content);

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++) {
                button[i][j] = new JButton();

                button[i][j].setFocusable(false);
                button[i][j].setActionCommand(i+""+j);
                button[i][j].addActionListener(this);

                if(state[i][j] == P[0])
                    button[i][j].setIcon(new ImageIcon(iconToken[0]));
                else if(state[i][j] == P[1])
                    button[i][j].setIcon(new ImageIcon(iconToken[1]));

                content.add(button[i][j]);
            }
        }

        frame.pack();
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int pos[]   = getPos(event.getActionCommand());
        int delta[] = {selection[0], selection[1]};

        int i;

        if(isSelection) {
            if(pos[0] == selection[0] && pos[1] == selection[1])
                selectPlayerMovement();
            else {
                if(state[pos[0]][pos[1]] == -P[playerTurn]) {
                    killToken(pos[0],pos[1]);
                    for(i = 0; i < 2; i++) {
                        delta[i] -= pos[i];
                        delta[i] *= -1;

                        pos[i] += delta[i];
                        if(pos[i] < 0)
                            pos[i] *= -1;
                        else if(pos[i] >= S[i]) {
                            pos[i] -= 2;
                        }
                    }
                }
                move(selection[0], selection[1], pos[0], pos[1]);
                flipTurn();
                selectPlayerMovement();
            }
            isSelection = false;
        } else {
            selectPossibleMovement(pos[0], pos[1]);
            isSelection = true;
        }

        selection[0] = pos[0];
        selection[1] = pos[1];
    }

    private void move(int xi, int yi, int xf, int yf) {
        state[xf][yf] = state[xi][yi];
        state[xi][yi] = BL;

        button[xi][yi].setIcon(null);

        button[xf][yf].setIcon(new ImageIcon(iconToken[playerTurn]));
    }

    private void killToken(int x, int y) {
        state[x][y] = BL;
        state[x][y] = BL;

        button[x][y].setIcon(null);
    }

    private void selectPossibleMovement(int x, int y) {
        int i, j;
        int delta[] = new int[2];

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++) {
                delta[0] = x;
                delta[1] = y;

                if(isVertical(y, j) &&
                   isHorizontal(x, i) &&
                  !isAlly(i, j))
                {
                    if(isEnnemy(i, j) &&
                       isBlocked(x, y, i, j))
                    {
                        button[i][j].setEnabled(false);
                    } else
                        button[i][j].setEnabled(true);
                } else
                    button[i][j].setEnabled(false);
            }
        }

        button[x][y].setEnabled(true);
    }

    private boolean isBlocked(int x, int y, int i, int j) {
        int delta[] = {x, y};
        int next[]  = {i, j};
        int block[] = new int[2];

        int k;

        for(k = 0; k < 2; k++) {
            delta[k] -= next[k];

            block[k] = next[k]-delta[k];
        }

        // it is blocked if it is out of bound
        if((block[0] < 0 || block[0] >= X) ||
           (block[1] < 0 || block[1] >= Y)) {
            return true;
        } else if(state[block[0]][block[1]] != BL)
            return true;

        return false;
    }

    private boolean isAlly(int x, int y) {
        if(state[x][y] == P[playerTurn])
            return true;

        return false;
    }

    private boolean isEnnemy(int x, int y) {
        if(state[x][y] != P[playerTurn] &&
           state[x][y] != BL)
            return true;

        return false;
    }

    private boolean isVertical(int y, int yv) {
        if((yv == y-1) || (yv == y+1))
            return true;

        return false;
    }

    private boolean isHorizontal(int x, int xh) {
        if(xh == x-1*P[playerTurn])
            return true;

        return false;
    }

    public void selectPlayerMovement() {
        int i, j;

        for(i = 0; i < X; i++) {
            for(j = 0; j < Y; j++) {
                if(state[i][j] != P[playerTurn])
                    button[i][j].setEnabled(false);
                else
                    button[i][j].setEnabled(true);
            }
        }
    }

    private int[] getPos(String cmd) {
        int pos[] = new int[2];

        pos[0] = Integer.parseInt(""+cmd.charAt(0));
        pos[1] = Integer.parseInt(""+cmd.charAt(1));

        return pos;
    }

    private void flipTurn() {
        playerTurn = (playerTurn==0?1:0);
    }
}

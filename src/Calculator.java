import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

    private JLabel unit1 = new JLabel("50000");
    private JLabel unit2 = new JLabel("10000");
    private JLabel unit3 = new JLabel("5000");
    private JLabel unit4 = new JLabel("1000");
    private JLabel unit5 = new JLabel("500");
    private JLabel unit6 = new JLabel("100");
    private JLabel unit7 = new JLabel("50");
    private JLabel unit8 = new JLabel("10");
    private JLabel unit9 = new JLabel("etc");

    private JLabel send_money = new JLabel("인계금액");
    private JTextField[] textField = new JTextField[10];

    int dragPosition = 0;

    private JLabel result1 = new JLabel("0");
    private JLabel result2 = new JLabel("0");
    private JLabel result3 = new JLabel("0");
    private JLabel result4 = new JLabel("0");
    private JLabel result5 = new JLabel("0");
    private JLabel result6 = new JLabel("0");
    private JLabel result7 = new JLabel("0");
    private JLabel result8 = new JLabel("0");
    private JLabel result9 = new JLabel("0");

    private JLabel sum = new JLabel("합계");
    private JLabel sumResult = new JLabel("0");
    private JButton calculate = new JButton("입력");

    Action buttonAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            int sum_50000 = 0;
            int sum_10000 = 0;
            int sum_5000 = 0;
            int sum_1000 = 0;
            int sum_500 = 0;
            int sum_100 = 0;
            int sum_50 = 0;
            int sum_10 = 0;
            int sum_etc = 0;

// 텍스트 필드가 null이 아니거나 비어있지 않은 경우에만 값을 가져옵니다.
            if (textField[0] != null && !textField[0].getText().isEmpty()) {
                sum_50000 = Integer.parseInt(textField[0].getText()) * 50000;
            }
            if (textField[1] != null && !textField[1].getText().isEmpty()) {
                sum_10000 = Integer.parseInt(textField[1].getText()) * 10000;
            }
            if (textField[2] != null && !textField[2].getText().isEmpty()) {
                sum_5000 = Integer.parseInt(textField[2].getText()) * 5000;
            }
            if (textField[3] != null && !textField[3].getText().isEmpty()) {
                sum_1000 = Integer.parseInt(textField[3].getText()) * 1000;
            }
            if (textField[4] != null && !textField[4].getText().isEmpty()) {
                sum_500 = Integer.parseInt(textField[4].getText()) * 500;
            }
            if (textField[5] != null && !textField[5].getText().isEmpty()) {
                sum_100 = Integer.parseInt(textField[5].getText()) * 100;
            }
            if (textField[6] != null && !textField[6].getText().isEmpty()) {
                sum_50 = Integer.parseInt(textField[6].getText()) * 50;
            }
            if (textField[7] != null && !textField[7].getText().isEmpty()) {
                sum_10 = Integer.parseInt(textField[7].getText()) * 10;
            }
            if (textField[8] != null && !textField[8].getText().isEmpty()) {
                sum_etc = Integer.parseInt(textField[8].getText());
            }


            result1.setText(sum_50000 + "");
            result2.setText(sum_10000 + "");
            result3.setText(sum_5000 + "");
            result4.setText(sum_1000 + "");
            result5.setText(sum_500 + "");
            result6.setText(sum_100 + "");
            result7.setText(sum_50 + "");
            result8.setText(sum_10 + "");
            result9.setText(sum_etc + "");

            int result = sum_50000 + sum_10000 + sum_5000
                    + sum_1000 + sum_500 + sum_100
                    + sum_50 + sum_10 + sum_etc;

            sumResult.setText(result + "");

            textField[dragPosition].setSelectionStart(0); // 선택 영역의 시작을 0으로 설정
            textField[dragPosition].setSelectionEnd(0);   // 선택 영역의 끝을 0으로 설정

            for (int i = 0; i < 10; i++) {
                if (textField[i].isFocusOwner()) {
                    dragPosition = i;
                }
            }

            dragPosition = (++dragPosition) % 10;

            int send_money = 0;

            if (textField[9] != null && !textField[9].getText().isEmpty()) {
                send_money = Integer.parseInt(textField[9].getText());
            }

            int different = send_money - result;

            differentResult.setText(different + "");

            textField[dragPosition].requestFocusInWindow();
            textField[dragPosition].selectAll(); // Select all text in the next text field
        }
    };

    private JLabel different = new JLabel("부족한 금액");
    private JLabel differentResult = new JLabel("0");

    private JLabel empty = new JLabel();

    Calculator() {
        for (int i = 0; i < 10; i++) {
            textField[i] = new JTextField("0");
            ((AbstractDocument) textField[i].getDocument()).setDocumentFilter(new DocumentFilter() {

                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if (text == null)
                        return;

                    StringBuilder builder = new StringBuilder(text);
                    for (int i = builder.length() - 1; i >= 0; i--) {
                        char ch = builder.charAt(i);
                        if (!Character.isDigit(ch)) {
                            builder.deleteCharAt(i);
                        }
                    }
                    text = builder.toString();

                    if (text.length() > 0 || offset > 0) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            });
            add(textField[i]);
        }

        unit1.setBackground(Color.LIGHT_GRAY);
        unit2.setBackground(new Color(220, 220, 220));
        unit3.setBackground(Color.LIGHT_GRAY);
        unit4.setBackground(new Color(220, 220, 220));
        unit5.setBackground(Color.LIGHT_GRAY);
        unit6.setBackground(new Color(220, 220, 220));
        unit7.setBackground(Color.LIGHT_GRAY);
        unit8.setBackground(new Color(220, 220, 220));
        unit9.setBackground(Color.LIGHT_GRAY);

        textField[dragPosition].selectAll();
        result1.setBackground(new Color(220, 220, 220));
        result2.setBackground(Color.WHITE);
        result3.setBackground(new Color(220, 220, 220));
        result4.setBackground(Color.WHITE);
        result5.setBackground(new Color(220, 220, 220));
        result6.setBackground(Color.WHITE);
        result7.setBackground(new Color(220, 220, 220));
        result8.setBackground(Color.WHITE);
        result9.setBackground(new Color(220, 220, 220));

        add(unit1);
        add(textField[0]);
        add(result1);
        add(unit2);
        add(textField[1]);
        add(result2);
        add(unit3);
        add(textField[2]);
        add(result3);
        add(unit4);
        add(textField[3]);
        add(result4);
        add(unit5);
        add(textField[4]);
        add(result5);
        add(unit6);
        add(textField[5]);
        add(result6);
        add(unit7);
        add(textField[6]);
        add(result7);
        add(unit8);
        add(textField[7]);
        add(result8);
        add(unit9);
        add(textField[8]);
        add(result9);
        add(send_money);
        add(textField[9]);
        add(empty);
        add(sum);
        add(sumResult);
        add(calculate);
        add(different);
        add(differentResult);

        addEnterKeyAction(calculate, buttonAction);
        calculate.addActionListener(buttonAction);

        setLayout(new GridLayout(12, 3,5,5));
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        // 모든 JLabel 텍스트 중앙 정렬 및 폰트 설정
        alignLabelsCenterAndSetFont(this.getContentPane(), new Font("NanumGothic", Font.PLAIN, 16));
    }

    private void addEnterKeyAction(JButton button, Action action) {
        // Enter 키를 누를 때 액션 실행하도록 설정
        InputMap im = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = button.getActionMap();
        im.put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
        am.put("enterAction", action);
    }

    private void alignLabelsCenterAndSetFont(Container container, Font font) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setFont(font);
                label.setOpaque(true); // 배경색을 설정하기 위해 불투명하게 설정
                //label.setBackground(Color.white); // 배경색 변경
            }
            else if(component instanceof JTextField){
                JTextField jTextField = (JTextField) component;
                jTextField.setHorizontalAlignment(SwingConstants.CENTER);
                //jTextField.setVerticalAlignment(SwingConstants.CENTER);
                jTextField.setFont(font);
                jTextField.setOpaque(true);
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

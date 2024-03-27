package state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);
    private TextArea textScreen = new TextArea(10, 60);
    private Button buttonUse = new Button("금고 사용");
    private Button buttonAlarm = new Button("비상벨");
    private Button buttonPhone = new Button("일반 통화");
    private Button buttonExit = new Button("종료");
    
    private State state = DayState.getInstance();
    
    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        
        add(panel, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        
        buttonUse.addActionListener(e -> state.doUse(this));
        buttonAlarm.addActionListener(e -> state.doAlarm(this));
        buttonPhone.addActionListener(e -> state.doPhone(this));
        buttonExit.addActionListener(e -> System.exit(0));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }
    
    @Override
    public void setClock(int hour) {
        String clockstring = String.format("%02d:00", hour);
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }
    
    @Override
    public void changeState(State state) {
        System.out.println(this.state + "에서 " + state + "로 상태가 변경되었습니다.");
        this.state = state;
    }
    
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }
    
    @Override
    public void recordLog(String msg) {
        textScreen.append("record " + msg + "\n");
    }
}
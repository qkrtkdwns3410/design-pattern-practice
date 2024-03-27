package state;

public interface Context {
    public void setClock(int hour); // 시간 설정
    
    public void changeState(State state); // 상태 전환
    
    public void callSecurityCenter(String msg); // 경비센터 호출
    
    public void recordLog(String msg); // 경비센터 기록
}
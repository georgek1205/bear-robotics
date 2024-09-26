package Card;

public class debitCard implements Card{

    private String cardNum;
    private String pin;
    public debitCard(String cardNum, String pin) {
        this.cardNum = cardNum;
        this.pin = pin;
    }

    @Override
    public boolean isValidPin(String pin) {
        if (this.pin.equals(pin)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}

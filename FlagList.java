public class FlagList {

    public Flag[] Cash = new Flag[3];
    public FlagList () {
        Cash[0] = new Flag(0,"United States","US");
        Cash[1] = new Flag(0,"Russia","RU");
        Cash[2] = new Flag(0,"Cook Islands","CK");
        
    }
    public Flag[] getCash () {
        return Cash;
    }
}
package my.t.sportszillia;

public class CardViewItem {

    private String mTextHeader, mTextSubheader;

    public CardViewItem(String TextHeader, String TextSubheader) {

        //variables added by the number of elements in view_booking_cardview_layout
        //add getters for each variable
        mTextHeader = TextHeader;
        mTextSubheader = TextSubheader;

    }

    public String getTextHeader() {
        return mTextHeader;
    }

    public String getTextSubheader() {
        return mTextSubheader;
    }
}


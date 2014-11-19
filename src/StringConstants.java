public interface StringConstants {
	//String keys for panels(Cardlayout)
	final static String LOGIN = "Login Screen";
	final static String CREATENEW = "Create New User";
	final static String CONN = "Connection Success Display"; 
	final static String ADDITEM = "Add Item";
	final static String REMOVEITEM = "Remove Item";
	final static String MYTRADES = "My Trades";
	final static String SEARCH = "Search";
	
	//Columns for TableModel
	final static String[] tradetableColumns = {"Item","Description","Category", "Offers?"};
	final static String[] tradeHistoryColumns = {"Item","OfferFrom","Item Offered", "DateOfOffer","DateAccepted"};
	final static String[] offerTableColumns = {"Item","OfferFrom","Item Offered", "DateOfOffer","Accepted?"};
	final static String[] searchtableColumns = {"Item","Description","Category","Person Trading"}; 
	
	//For ComboBoxes
	final static String[] searchBy = {"ItemName","Category", "User"};
	final static String[] StatesList = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
		"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
		"Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massacusetts", "Michigan", "Minnesota", "Mississippi",
		"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
		"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", 
		"South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
		"West Virginia", "Wisconsin", "Wyoming"};
}
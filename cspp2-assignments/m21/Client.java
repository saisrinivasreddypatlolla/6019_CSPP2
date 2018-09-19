import java.util.Scanner;
class FoodLog {
	String foodName;
	double quantity;
	String date;
	String time;
	FoodLog() {

	}
	FoodLog(String foodName1, double quantity1, String date1, String time1) {
		this.foodName = foodName1;
		this.quantity = quantity1;
		this.time = time1;
		this.date = date1;
	}
	public String getFoodName() {
		return this.foodName;
	}
	public double getQuantity() {
		return this.quantity;
	}
	public String getTime() {
		return this.time;
	}
	public String getDate() {
		return this.date;
	}
	// public String toString() {
	// 	String s = "";
	// 	s += "Food" + "\n" +
	// 	     "Date:" + this.date + "\n" + "Time:" + this.time + "\n" + "Name:" + this.foodName + "\n" + "Quantity:" + this.quantity;
	// 	return s;
	// }
}
class WaterLog {
	double waterQuantity;
	String date;
	String waterTime;
	WaterLog() {

	}
	WaterLog(double waterQuantity1, String date1, String waterTime1) {
		this.waterQuantity = waterQuantity1;
		this.waterTime = waterTime1;
		this.date = date1;
	}
	public double getWaterQuantity() {
		return this.waterQuantity;
	}
	public String getWaterTime() {
		return this.waterTime;
	}
	public String getDate() {
		return this.date;
	}
	// public String toString() {
	// 	String s = "";
	// 	s += "Water" + "\n" +
	// 	     "Date:" + this.date + "\n" + "Quantity:" + this.waterQuantity;
	// 	return s;
	// }
}
class Activity {
	String activityName;
	String date;
	String startTime;
	String endTime;
	String notes;
	Activity() {

	}
	Activity(String activityName1, String notes1, String date1, String startTime1, String endTime1) {
		this.activityName = activityName1;
		this.date = date1;
		this.startTime = startTime1;
		this.endTime = endTime1;
		this.notes = notes1;
	}
	public String getAcitivityName() {
		return this.activityName;
	}
	public String getDate() {
		return this.date;
	}
	public String getStartTime() {
		return this.startTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public String getNotes() {
		return this.notes;
	}
	// public String toString() {
	// 	String s = "";
	// 	s += "PhysicalActivity" + "\n" +
	// 	     "Name:" + this.activityName + "\n" + "Notes:" + this.notes + "\n" + "Date:" + this.date + "\n" + "StartTime:" + this.startTime + "\n" + "EndTime:" + this.endTime;
	// 	return s;
	// }
}
class Weight {
	String date;
	String weightOne;
	String fat;
	String weightTime;
	Weight() {

	}
	Weight(String date1, String weightTime1, String weight1, String fat1) {
		this.weightOne = weight1;
		this.fat = fat1;
		this.weightTime = weightTime1;
		this.date = date1;
	}
	public String getWeight() {
		return this.weightOne;
	}
	public String getFat() {
		return this.fat;
	}
	public String getWeightTime() {
		return this.weightTime;
	}
	public String getDate() {
		return this.date;
	}
	// public String toString() {
	// 	String s = "";
	// 	s += "Weight" + "\n" +
	// 	     "Date:" + this.date + "\n" + "Time:" + this.weightTime + "\n" + "Weight:" + this.weightOne + "\n" + "Fat" + this.fat;
	// 	return s;
	// }
}
class Sleep {
	String date;
	String dateStartTime;
	String dateEndTime;
	Sleep() {

	}
	Sleep(String date1, String dateStartTime1, String dateEndTime1) {
		this.date = date1;
		this.dateStartTime = dateStartTime1;
		this.dateEndTime = dateEndTime1;
	}
	public String getDateStartTime() {
		return this.dateStartTime;
	}
	public String getDateEndTime() {
		return this.dateEndTime;
	}
	public String getDate() {
		return this.date;
	}
	// public String toString() {
	// 	String s = "";
	// 	s += "Sleep" + "\n" + "Date:" + this.date + "\n" +
	// 	     "Starttime:" + this.dateStartTime + "\n" + "Endtime:" + this.dateEndTime;
	// 	return s;
	// }
}
class Summary {
	final int TEN = 10;
	int a = 0, b = 0, c = 0, d = 0, e = 0;
	FoodLog[] foodObj = new FoodLog[TEN];
	WaterLog[] waterObj = new WaterLog[TEN];
	Activity[] activityObj = new Activity[TEN];
	Weight[] weightObj = new Weight[TEN];
	Sleep[] sleepObj = new Sleep[TEN];
	Summary() {

	}
	public void addFood(FoodLog item) {
		// System.out.println(a + " " + item);
		foodObj[a] = item;
		// System.out.println(foodObj[a].getFoodName());
		a++;
	}
	public void addWater(WaterLog item) {
		// System.out.println(b + " " + item);
		waterObj[b] = item;
		b++;
	}
	public void addActivity(Activity item) {
		// System.out.println(c + " " + item);
		activityObj[c] = item;
		c++;
	}
	public void addWeight(Weight item) {
		// System.out.println(d + " " + item);
		weightObj[d] = item;
		d++;
	}
	public void addSleep(Sleep item) {
		// System.out.println(e + " " + item);
		sleepObj[e] = item;
		e++;
	}
	public FoodLog getFoodLog(int index) {
		return foodObj[index];
	}
	public WaterLog getWaterLog(int index) {
		return waterObj[index];
	}
	public Activity getActivity(int index) {
		return activityObj[index];
	}
	public Weight getWeight1(int index) {
		return weightObj[index];
	}
	public Sleep getSleep(int index) {
		return sleepObj[index];
	}
	public void foodPrint() {
		String s = "";
		for (int i = 0; i < a; i++) {
			s += "Food" + "\n" + "Date:" + getFoodLog(i).getDate() + "\n" + "Time:" + getFoodLog(i).getTime() + "\n" +
			     "Name:" + getFoodLog(i).getFoodName() + "\n" + "Quantity" + getFoodLog(i).getQuantity();
		}
		System.out.println(s);
	}
	public void waterPrint() {
		String s = "";
		for (int i = 0; i < b; i++) {
			s += "Water" + "\n" + "Date:" + getWaterLog(i).getDate() + "\n" +
			     "Quantity:" + getWaterLog(i).getWaterQuantity();
		}
		System.out.println(s);
	}
	public void activityPrint() throws Exception {
		if (c == 0) {
			System.out.println("PhysicalActivity");
			throw new Exception("None");
		}
		String s = "";
		for (int i = 0; i < c; i++) {
			s += "PhysicalActivity" + "\n" + "Name:" + getActivity(i).getAcitivityName() + "\n" +
			     "Notes:" + getActivity(i).getNotes() + "\n" + "Date:" + getActivity(i).getDate() + "\n" +
			     "Starttime:" + getActivity(i).getStartTime() + "\n" + "Endtime:" + getActivity(i).getEndTime();
		}
		System.out.println(s);
	}
	public void weightPrint() {
		String s = "";
		for (int i = 0; i < d; i++) {
			s += "Weight" + "\n" + "Date:" + getWeight1(i).getDate() + "\n" + "Time:" +
			     getWeight1(i).getWeightTime() + "\n" + "Weight" + getWeight1(i).getWeight() + "\n" + "Fat" + getWeight1(i).getFat();
		}
		System.out.println(s);
	}
	public void sleepPrint() {
		String s = "";
		for (int i = 0; i < e; i++) {
			s += "Sleep" + "\n" + "Date:" + getSleep(i).getDate() + "\n" + "Starttime:" + getSleep(i).getDateStartTime() + "\n" +
			     "Endtime:" + getSleep(i).getDateStartTime();
		}
		System.out.println(s);
	}
	public void print() {
		foodPrint();
		waterPrint();
		try {
			activityPrint();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		weightPrint();
		sleepPrint();
	}
	public void print(String date) {
		String s = "";
		for (int i = 0; i < a; i++) {
			if (date.equals(getFoodLog(i).getDate())) {
				s += "Food" + "\n" + "Date:" + getFoodLog(i).getDate() + "\n" + "Time:" + getFoodLog(i).getTime() + "\n" +
				     "Name:" + getFoodLog(i).getFoodName() + "\n" + "Quantity" + getFoodLog(i).getQuantity() + "\n" + "Water" + "\n" + "Date:" + getWaterLog(i).getDate() + "\n" +
				     "Quantity:" + getWaterLog(i).getWaterQuantity() + "\n" + "PhysicalActivity" + "\n" + "Name:" + getActivity(i).getAcitivityName() + "\n" +
				     "Notes:" + getActivity(i).getNotes() + "\n" + "Date:" + getActivity(i).getDate() + "\n" +
				     "Starttime:" + getActivity(i).getStartTime() + "\n" + "Endtime:" + getActivity(i).getEndTime() + "\n" + "Weight" + "\n" + "Date:" + getWeight1(i).getDate() + "\n" + "Time:" +
				     getWeight1(i).getWeightTime() + "\n" + "Weight" + getWeight1(i).getWeight() + "\n" + "Fat" + getWeight1(i).getFat() + "\n" + "Sleep" + "\n" + "Date:" + getSleep(i).getDate() + "\n" + "Starttime:" + getSleep(i).getDateStartTime() + "\n" +
				     "Endtime:" + getSleep(i).getDateStartTime();
			}
		}
		System.out.println(s);
		return;
	}

}
class Client {
	private static int size = 0;
	public static void main(String[] args) {
		Summary s = new Summary();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String input = scan.nextLine();
			String[] tokens = input.split(" ");
			// System.out.println(tokens[0] + "---" + tokens[1]);
			try {
				switch (tokens[0]) {
				case "Food":
					String[] items = tokens[1].split(",");
					s.addFood(new FoodLog(items[0], Double.parseDouble(items[1]), items[2], items[3]));
					size++;
					break;
				case "Water":
					items = tokens[1].split(",");
					s.addWater(new WaterLog(Double.parseDouble(items[0]), items[1], items[2]));
					break;
				case "PhysicalActivity":
					items = tokens[1].split(",");
					s.addActivity(new Activity(items[0], items[1], items[2], items[3], items[4]));
					break;
				case "Weight":
					items = tokens[1].split(",");
					s.addWeight(new Weight(items[0], items[1], items[2], items[3]));
					break;
				case "Sleep":
					items = tokens[1].split(",");
					s.addSleep(new Sleep(items[0], items[1], items[2]));
					break;
				case "Foodlog":
					// System.out.println("hello");
					s.foodPrint();
					System.out.println();
					break;
				case "Waterlog":
					s.waterPrint();
					System.out.println();
					break;
				case "PhysicalActivitylog":
					s.activityPrint();
					System.out.println();
					break;
				case "Weightlog":
					s.weightPrint();
					System.out.println();
					break;
				case "Sleeplog":
					s.sleepPrint();
					System.out.println();
					break;
				case "Summary":
					if (tokens.length == 2) {
						s.print(tokens[1]);
						break;
					}
					s.print();
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage() + "\n");
			}
		}

	}
}
class Quiz{
	int size = 0,i=0;
	int count = 0;
	String question,userAnswer1;
	String[] option = new String[10];
	int mark,penality;
	String answer;
	String[] questions = new String[10];
	String[][] options = new String[10][10];
	String[] answers = new String[10];
	int[] marks = new int[10];
	int[] penalitys = new int[10];
	String[] userAnswer = new String[10];
	Quiz(){

	}
	Quiz(String question1, String[] options1,String answer1,int marks1, int penality1){
		this.question = question1;
		this.option= options1;
		this.answer = answer1;
		this.mark = marks1;
		this.penality = penality1;
	}
	Quiz(String user){
		this.userAnswer1 = user;
	}
	public void add(Quiz q){
		questions[size] = q.question;
		options[size] = q.option;
		answers[size] = q.answer;
		marks[size] = q.mark;
		penalitys[size] = q.penality;
		size++;
	}
	public void Check(Quiz q){

	}
	// public String getQuestion(){
	// 	return this.question;
	// }
	// public String[] getOptions(){
	// 	return this.options;
	// }
	// public int getAnswer(){
	// 	return this.answer;
	// }
	// public int getMarks(){
	// 	return this.marks;
	// }
	// public int getPenality(){
	// 	return this.penality;
	// }
	public void print(int ques){
		for(int i = 0;i<ques;i++){
			System.out.println(questions[i]+"("+marks[i]+")");
			for(int j=0;j<options[i].length-1;j++){
				System.out.print(options[i][j]+"\t");
			}System.out.print(options[i][options[i].length-1]);
			System.out.println();

		}
	}
}
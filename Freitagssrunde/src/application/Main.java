package application;
	
import javafx.application.Application;
import Handler.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


public class Main extends Application {
	
	Handler hand;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			hand = new Handler();
			primaryStage.setTitle("Hangman");
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			
			TextField field = new TextField("Hangman-Figur");
			field.setId("hangman-figur");
			grid.add(field, 0, 0);
			
			Text scenetitle = new Text("Welcome");
			scenetitle.setId("welcome-text");
			grid.add(scenetitle, 0, 0, 2, 1);
			
			Label userName = new Label("User Name: ");
			grid.add(userName, 0, 1);
			
			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);
			
			Label pw = new Label("Password:");
			grid.add(pw, 0, 2);
			
			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);
			
			Button nbS = new Button("Neuer Buchstabe");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(nbS);
			
			Button btn = new Button("Sign in");
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);
			
			final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);
			actiontarget.setId("actiontarget");
			
			nbS.setOnAction(new EventHandler<ActionEvent>(){
				
				public void handle(ActionEvent e){
					Stage stage = new Stage();
					GridPane grid = new GridPane();
					stage.setScene(new Scene(grid, 200,100));
					
//					stage.setTitle("Neuer Buchstabe");
//					Label label = new Label("Buchstabe");
//					grid.add(label, 0, 0);					
//					TextField field = new TextField();
//					grid.add(field, 0, 1);
					
					Button a = new Button("A");
					a.setText("a");
					Button b = new Button("B");
					b.setText("b");
					Button c = new Button("C");
					c.setText("c");
					Button d = new Button("D");
					d.setText("d");
					Button e1 = new Button("E");
					e1.setText("e");
					Button f = new Button("F");
					f.setText("f");
					Button g = new Button("G");
					g.setText("g");
					Button h = new Button("H");
					h.setText("h");
					Button i = new Button("I");
					i.setText("i");
					Button j = new Button("J");
					j.setText("j");
					Button k = new Button("K");
					k.setText("k");
					Button l = new Button("L");
					l.setText("l");
					Button m = new Button("M");
					m.setText("m");
					Button n = new Button("N");
					n.setText("n");
					Button o = new Button("O");
					o.setText("o");
					Button p = new Button("P");
					p.setText("p");
					Button q = new Button("Q");
					q.setText("q");
					Button r = new Button("R");
					r.setText("r");
					Button s = new Button("S");
					s.setText("s");
					Button t = new Button("T");
					t.setText("t");
					Button u = new Button("U");
					u.setText("u");
					Button v = new Button("V");
					v.setText("v");
					Button w = new Button("W");
					w.setText("w");
					Button x = new Button("X");
					x.setText("x");
					Button y = new Button("Y");
					y.setText("y");
					Button z = new Button("Z");
					z.setText("z");
					
					HBox box = new HBox(10);
					Button[] bButtonArray = {a,b,c,d,e1,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
					for(int xy = 0; xy < bButtonArray.length; ++xy){
						if(hand.buchstabeVorhanden(bButtonArray[xy].getText().toCharArray()[0]))
								continue;
						else
								box.getChildren().add(bButtonArray[xy]);
					}
					
					Button ok = new Button("OK");
					
					box.setAlignment(Pos.BOTTOM_RIGHT);
					box.getChildren().add(ok);
					grid.add(box, 0, 2);
					stage.show();
					
					ok.setOnAction(new EventHandler<ActionEvent>(){

						@Override
						public void handle(ActionEvent arg0) {
							String wert = field.getText();
							char[] array = wert.toCharArray();
							hand.setNewBuchstabe(array[0]);
							System.out.println(array[0]);
							stage.close();							
						}
						
					});					
				}
			});
			
			btn.setOnAction(new EventHandler<ActionEvent>(){
				
				@Override
				public void handle(ActionEvent e){
					actiontarget.setText(("Sign in button pressed"));
				}
			});
			
			Scene scene = new Scene(grid, 300, 275);
			primaryStage.setScene(scene);
			scene.getStylesheets().add
					(Main.class.getResource("Login.css").toExternalForm());
						
			primaryStage.show();
			
			
//			Circle circle = new Circle(100,100,100);
//			StackPane root = new StackPane();
//			root.getChildren().add(new Button("Hallo"));
//			root.setShape(circle);
////			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			scene.setFill(Color.TRANSPARENT);
//			primaryStage.setScene(scene);
//			primaryStage.initStyle(StageStyle.TRANSPARENT);
//			primaryStage = new Stage();
//			primaryStage.show();
//			primaryStage.setTitle("Meine GUI");
//			Stage stage = new Stage();
//			stage.setTitle("Dialog");
//			stage.setScene(new Scene(new StackPane(new Label("Nachricht!"))));
//			stage.initOwner(primaryStage);
//			stage.initModality(Modality.WINDOW_MODAL);
//			stage.show();
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

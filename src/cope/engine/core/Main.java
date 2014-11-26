package cope.engine.core;
import java.awt.Font;
import java.io.IOException;

import cope.engine.input.Button;
import cope.engine.input.ButtonEvent;
import cope.engine.input.InputManager;
import cope.engine.rendering.Colour;
import cope.engine.rendering.Display;
import cope.engine.rendering.Screen;
import cope.engine.rendering.Sprite;
import cope.engine.rendering.TextObject;
import cope.engine.util.Matrix;
import cope.engine.util.Vector;


public class Main {
	
	//TODO: Screens, Transitions, Animations, Fix transformations to use matrices.
	
	public static void main(String[] args) throws IOException{
		
		Matrix A = new Matrix(1, 2);
		float valuesA[][] = {{0, 2}};
		A.setValues(valuesA);
		System.out.println(A.toString());
		
		Matrix B = new Matrix(2);
		float valuesB[][] = {{2, 0}, {-1, 1}};
		B.setValues(valuesB);
		System.out.println(B.toString());
		
		System.out.println(A.mul(B).toString());
		System.out.println(B.mul(A).toString());
		
		Display display = new Display(600, 600, "2D Engine");
		
		Game game = new Game();
		float delta = 0;
		
		TextObject text = new TextObject();
		text.setText("OmegaCraftable");
		text.setFont("Bebas Neue");
		text.setStyle(Font.BOLD);
		text.setSize(40);
		text.setColour(Colour.WHITE);
		text.setPosition(new Vector(300 - text.getWidth() / 2, 300 - text.getHeight() / 2));
		
		Sprite sprite = new Sprite(new Vector(300, 350), "test.jpg");
		
		sprite.scale(5);
		
		Button button = new Button(sprite, new ButtonEvent() {

			@Override
			public void onPress() {
				System.out.println("Pressed");
				
			}

			@Override
			public void onRelease() {
				System.out.println("Released");
			}

			@Override
			public void whilePressed() {
				
			}
			
		});
		
		InputManager manager = new InputManager(display.getInput());
		manager.addButton(button);
		
		Screen screen = new Screen();
		screen.addObject(sprite, 1);
		screen.addObject(text, 2);
		display.showScreen(screen);
		
		while (true){
			long startTime = System.currentTimeMillis();

			display.fill(50);
			
//			button.rotate(0.1f * delta);
//			
//			sprite.render(display);
			game.update(delta);
			game.render(display.getFrameBuffer());
			display.getFrameBuffer().drawCircle(100, 100, 30, Colour.WHITE, false);
//			text.render(display);
//			
			manager.update();
			display.showBufferStrategy();
			
			
			long endTime = System.currentTimeMillis();
			delta = endTime - startTime;
			
		}

	}
	
}

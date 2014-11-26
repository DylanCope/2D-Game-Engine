package cope.engine.rendering;

public class ScreenObject {

	private float depth;
	private ScreenObject object;
	private String className;
	private boolean showObject;
	
	public float getDepth()
	{
		return depth;
	}
	
	public void setDepth(float depth)
	{
		this.depth = depth;
	}
	
	public void showObject() { showObject = true;  }
	public void hideObject() { showObject = false; }
	public boolean isRendering() { return showObject; }
	
	public void setObject(ScreenObject object)
	{
		this.object = object;
		className = object.getClass().getSimpleName();
		showObject = true;
	}
	
	public void render(Display display)
	{
		if (showObject) 
		{
			if (className.equals("Sprite"))
				((Sprite) object).render(display);
			if (className.equals("Bitmap"))
				((Bitmap) object).render(display);
			if (className.equals("TextObject"))
				((TextObject) object).render(display);
		}
	}
}

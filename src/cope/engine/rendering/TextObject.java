package cope.engine.rendering;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;

import cope.engine.util.Vector;


public class TextObject extends ScreenObject{
	
	private String m_font;
	private String m_text;
	private Vector m_position;
	
	private int m_size, m_style;
	private Colour m_colour;
	
	public TextObject()
	{
		m_text = "TEXT OBJECT";
		m_position = new Vector(0, 0);
		m_size = 20;
		m_font = "Times New Roman";
		m_style = Font.PLAIN;
		m_colour = Colour.BLACK;
		
		setObject(this);
		
	}
	
	public TextObject(String text, Vector position)
	{
		m_text = text;
		m_position = position;
		
		m_size = 12;
		m_font = "Times New Roman";
		m_style = Font.PLAIN;
		m_colour = Colour.BLACK;

		setObject(this);
	}

	public TextObject(String text, String font, int size, Vector position)
	{
		m_position = position;
		m_size = size;
		m_text = text;
		m_font = font;
		
		m_style = Font.PLAIN;
		m_colour = Colour.BLACK;

		setObject(this);
	}
	
	public TextObject(String text, String font, int size, int style, Vector position)
	{
		m_position = position;
		m_size = size;
		m_style = style;
		m_text = text;
		
		m_colour = Colour.BLACK;

		setObject(this);
	}
	
	public void render(Display display)
	{
		display.drawText(
				(int) m_position.getX(), 
				(int) m_position.getY(), 
				m_text, 
				new Font(m_font, m_style, m_size), 
				new Color(
						m_colour.getR(),
						m_colour.getG(),
						m_colour.getB(),
						m_colour.getA()
						)
				);
	}
	
	public int getWidth() {
		return (int) 
				new Font(m_font, m_style, m_size)
					.getStringBounds(
						m_text, 
						new FontRenderContext(null, true, false)
					).getWidth();
	}
	
	public int getHeight() {
		return (int) 
				new Font(m_font, m_style, m_size)
					.getStringBounds(
						m_text, 
						new FontRenderContext(null, true, false)
					).getHeight();
	}
	
	public void setText(String text) {
		m_text = text;
	}
	
	public void setFont(String font) {
		m_font = font;
	}
	
	public void setStyle(int style) {
		m_style = style;
	}
	
	public void setSize(int size) {
		m_size = size;
	}
	
	public void setColour(Colour colour) {
		m_colour = colour;
	}
	
	public void setPosition(Vector position) {
		m_position = position;
	}
	
	public String getText()	{
		return m_text;
	}
	
	public Font getFont() {
		return new Font(m_font, m_style, m_size);
	}
	
	public int getStyle() {
		return m_style;
	}
	
	public int getSize() {
		return m_size;
	}
	public Colour getColour() {
		return m_colour;
	}
	
	public Vector getPosition() {
		return m_position;
	}
	
}

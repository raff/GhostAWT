package ghostawt.image;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.HashMap;

public class GGraphics2D extends Graphics2D {
    private GraphicsConfiguration _configuration;

    private Color foreground = Color.black;
    private Color background = Color.white;
    private Paint paint = Color.black;
    private Font font = new Font(Font.DIALOG, Font.PLAIN, 12);
    private Rectangle clipBounds;

    private RenderingHints renderingHints;

    public GGraphics2D(GraphicsConfiguration configuration) {
	Logger.log("GGraphics2D", configuration);
        _configuration = configuration;
	renderingHints = new RenderingHints(new HashMap<Key, Object>());
    }

    @Override
    public void draw(Shape s) {
	Logger.log("GGraphics2D draw", s);
    }

    @Override
    public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
	Logger.log("GGraphics2D drawImage", img, xform, obs);
        return false;
    }

    @Override
    public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
	Logger.log("GGraphics2D drawImage", img, op, x, y);
    }

    @Override
    public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
	Logger.log("GGraphics2D drawRenderedImage", img, xform);
    }

    @Override
    public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
	Logger.log("GGraphics2D drawRenderableImage", img, xform);
    }

    @Override
    public void drawString(String str, int x, int y) {
	Logger.log("GGraphics2D drawString", str, x, y);
    }

    @Override
    public void drawString(String str, float x, float y) {
	Logger.log("GGraphics2D drawString", str, x, y);
    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, int x, int y) {
	Logger.log("GGraphics2D drawString", iterator, x, y);
    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, float x, float y) {
	Logger.log("GGraphics2D drawString", iterator, x, y);
    }

    @Override
    public void drawGlyphVector(GlyphVector g, float x, float y) {
	Logger.log("GGraphics2D drawGlyphVecotr", g, x, y);
    }

    @Override
    public void fill(Shape s) {
	Logger.log("GGraphics2D fill", s);
    }

    @Override
    public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
	Logger.log("GGraphics2D hit", rect, s, onStroke);
        return false;
    }

    @Override
    public GraphicsConfiguration getDeviceConfiguration() {
	Logger.log("GGraphics2D getDeviceConfiguration");
        return _configuration;
    }

    @Override
    public void setComposite(Composite comp) {
	Logger.log("GGraphics2D setComposite", comp);
    }

    @Override
    public void setPaint(Paint p) {
	Logger.log("GGraphics2D setPaint", p);
        paint = p;
    }

    @Override
    public void setStroke(Stroke s) {
	Logger.log("GGraphics2D setStroke", s);
    }

    @Override
    public void setRenderingHint(Key hintKey, Object hintValue) {
	Logger.log("GGraphics2D setRenderingHint", hintKey, hintValue);
	renderingHints.put(hintKey, hintValue);
    }

    @Override
    public Object getRenderingHint(Key hintKey) {
	Logger.log("GGraphics2D getRenderingHint");
        return renderingHints.get(hintKey);
    }

    @Override
    public void setRenderingHints(Map<?, ?> hints) {
	Logger.log("GGraphics2D setRenderingHints", hints);
	renderingHints.clear();
	renderingHints.putAll(hints);
    }

    @Override
    public void addRenderingHints(Map<?, ?> hints) {
	Logger.log("GGraphics2D addRenderingHints", hints);
	renderingHints.putAll(hints);
    }

    @Override
    public RenderingHints getRenderingHints() {
	Logger.log("GGraphics2D getRenderingHints");
        return renderingHints;
    }

    @Override
    public void translate(int x, int y) {
	Logger.log("GGraphics2D translate", x, y);
    }

    @Override
    public void translate(double tx, double ty) {
	Logger.log("GGraphics2D translate", tx, ty);
    }

    @Override
    public void rotate(double theta) {
	Logger.log("GGraphics2D rotate", theta);
    }

    @Override
    public void rotate(double theta, double x, double y) {
	Logger.log("GGraphics2D rotate", theta, x, y);
    }

    @Override
    public void scale(double sx, double sy) {
	Logger.log("GGraphics2D scale", sx, sy);
    }

    @Override
    public void shear(double shx, double shy) {
	Logger.log("GGraphics2D scale", shx, shy);
    }

    @Override
    public void transform(AffineTransform Tx) {
	Logger.log("GGraphics2D transform", Tx);
    }

    @Override
    public void setTransform(AffineTransform Tx) {
	Logger.log("GGraphics2D setTransform", Tx);
    }

    @Override
    public AffineTransform getTransform() {
	Logger.log("GGraphics2D getTransform");
        return new AffineTransform();
    }

    @Override
    public Paint getPaint() {
	Logger.log("GGraphics2D getPaint");
        return paint;
    }

    @Override
    public Composite getComposite() {
	Logger.log("GGraphics2D getComposite");
        return AlphaComposite.SrcOver;
    }

    @Override
    public void setBackground(Color color) {
	Logger.log("GGraphics2D setBackground", color);
	background = color;
    }

    @Override
    public Color getBackground() {
	Logger.log("GGraphics2D getBackground");
        return background;
    }

    @Override
    public Stroke getStroke() {
	Logger.log("GGraphics2D getStroke");
        return new BasicStroke();
    }

    @Override
    public void clip(Shape s) {
	Logger.log("GGraphics2D clip", s);
    }

    @Override
    public FontRenderContext getFontRenderContext() {
	Logger.log("GGraphics2D getFontRenderContext");
        return new FontRenderContext(new AffineTransform(), false, false);
    }

    @Override
    public Graphics create() {
        Graphics g = new GGraphics2D(_configuration);
	Logger.log("GGraphics2D create", g);
	return g;
    }

    @Override
    public Color getColor() {
	Logger.log("GGraphics2D getColor");
        return foreground;
    }

    @Override
    public void setColor(Color c) {
	Logger.log("GGraphics2D setColor", c);
        foreground = c;
    }

    @Override
    public void setPaintMode() {
	Logger.log("GGraphics2D setPaintMode");
    }

    @Override
    public void setXORMode(Color c1) {
	Logger.log("GGraphics2D setXORMode", c1);
    }

    @Override
    public Font getFont() {
	Logger.log("GGraphics2D getFont");
        return font;
    }

    @Override
    public void setFont(Font f) {
	Logger.log("GGraphics2D setFont", f);
	font = f;
    }

    @Override
    public FontMetrics getFontMetrics(Font f) {
	Logger.log("GGraphics2D getFontMetrics", f);
        return new GFontMetrics(f);
    }

    @Override
    public Rectangle getClipBounds() {
	Logger.log("GGraphics2D getClipBounds", clipBounds);
        return clipBounds;
    }

    @Override
    public void clipRect(int x, int y, int width, int height) {
	Logger.log("GGraphics2D clipRect", x, y, width, height);
	clipBounds = new Rectangle(x, y, width, height);
    }

    @Override
    public void setClip(int x, int y, int width, int height) {
	Logger.log("GGraphics2D setClip", x, y, width, height);
	clipBounds = new Rectangle(x, y, width, height);
    }

    @Override
    public Shape getClip() {
	Logger.log("GGraphics2D getClip");
        return null;
    }

    @Override
    public void setClip(Shape clip) {
	Logger.log("GGraphics2D setClip", clip);
	if (clip == null) {
		clipBounds = null;
	} else {
		clipBounds = clip.getBounds();
	}
    }

    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
    }

    @Override
    public void clearRect(int x, int y, int width, int height) {
    }

    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
    }

    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
    }

    @Override
    public void drawOval(int x, int y, int width, int height) {
    }

    @Override
    public void fillOval(int x, int y, int width, int height) {
    }

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
    }

    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
    }

    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
    }

    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
    }

    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
    }

    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public void dispose() {
	Logger.log("GGraphics2D dispose", this);
    }

}

package patterns.proxy;

public class ProxyImage implements Image{

	private final String filename;
	private RealImage realImage;

	public ProxyImage(String filename) {
		this.filename = filename;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(filename);
		}
		System.out.println("Proxy: delegating display to real object");
		realImage.display();
	}
}

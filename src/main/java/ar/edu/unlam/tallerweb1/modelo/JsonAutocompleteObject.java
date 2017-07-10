package ar.edu.unlam.tallerweb1.modelo;

public class JsonAutocompleteObject {
	
	private String id;
	private String label;
	private String value;
	private String extraValue;
	private String extraValue2;
	
	// CONSTRUCTORES
	public JsonAutocompleteObject(String id, String label, String value) {
		super();
		this.id = id;
		this.label = label;
		this.value = value;
	}

	public JsonAutocompleteObject(String id, String label, String value, String extraValue) {
		super();
		this.id = id;
		this.label = label;
		this.value = value;
		this.extraValue = extraValue;
	}

	public JsonAutocompleteObject(String id, String label, String value, String extraValue, String extraValue2) {
		super();
		this.id = id;
		this.label = label;
		this.value = value;
		this.extraValue = extraValue;
		this.extraValue2 = extraValue2;
	}

	public JsonAutocompleteObject(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

	// GETTERS y SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExtraValue() {
		return extraValue;
	}

	public void setExtraValue(String extraValue) {
		this.extraValue = extraValue;
	}

	public String getExtraValue2() {
		return extraValue2;
	}

	public void setExtraValue2(String extraValue2) {
		this.extraValue2 = extraValue2;
	}
}

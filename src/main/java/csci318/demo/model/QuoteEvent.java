package csci318.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuoteEvent {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String type;

    @Column(name="value")
    /** @valueRecord is a string format for a Value object.
     * Here we use flat denormalization for object persistence.
     */
    private String valueRecord;

    public QuoteEvent() {
    }

    public QuoteEvent(Quote quote) {
        super();
        this.setType(quote.getType());
        this.setValueRecord(quote.getValue().toString());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValueRecord() {
        return valueRecord;
    }

    public void setValueRecord(String valueRecord) {
        this.valueRecord = valueRecord;
    }
}

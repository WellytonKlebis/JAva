
package model;

import  java.util.Date;



public class tesks {
    private int id;
    private int idproject;
    private String description;
    private String notes;
    private boolean iscompleted;
    private Date deadline;
    private Date createdAt;
    private Date uptdatedAt;

    public tesks(int id, int idproject, String description, String notes, boolean iscompleted, Date deadline, Date createdAt, Date uptdatedAt) {
        this.id = id;
        this.idproject = idproject;
        this.description = description;
        this.notes = notes;
        this.iscompleted = iscompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.uptdatedAt = uptdatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproject() {
        return idproject;
    }

    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUptdatedAt() {
        return uptdatedAt;
    }

    public void setUptdatedAt(Date uptdatedAt) {
        this.uptdatedAt = uptdatedAt;
    }

    @Override
    public String toString() {
        return "tesks{" + "id=" + id + ", idproject=" + idproject + ", description=" + description + ", notes=" + notes + ", iscompleted=" + iscompleted + ", deadline=" + deadline + ", createdAt=" + createdAt + ", uptdatedAt=" + uptdatedAt + '}';
    }
    
   
    
    
    
    
}


package es.unex.giiis.asee.executorslab.model;

import java.util.List;

import es.unex.giiis.asee.executorslab.model.Owner;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ticket {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("project")
    @Expose
    private String project;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("hashtags")
    @Expose
    private List<Object> hashtags = null;
    @SerializedName("change_id")
    @Expose
    private String changeId;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("submit_type")
    @Expose
    private String submitType;
    @SerializedName("mergeable")
    @Expose
    private Boolean mergeable;
    @SerializedName("insertions")
    @Expose
    private Integer insertions;
    @SerializedName("deletions")
    @Expose
    private Integer deletions;
    @SerializedName("total_comment_count")
    @Expose
    private Integer totalCommentCount;
    @SerializedName("unresolved_comment_count")
    @Expose
    private Integer unresolvedCommentCount;
    @SerializedName("has_review_started")
    @Expose
    private Boolean hasReviewStarted;
    @SerializedName("_number")
    @Expose
    private Integer number;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("requirements")
    @Expose
    private List<Object> requirements = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Object> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Object> hashtags) {
        this.hashtags = hashtags;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public Boolean getMergeable() {
        return mergeable;
    }

    public void setMergeable(Boolean mergeable) {
        this.mergeable = mergeable;
    }

    public Integer getInsertions() {
        return insertions;
    }

    public void setInsertions(Integer insertions) {
        this.insertions = insertions;
    }

    public Integer getDeletions() {
        return deletions;
    }

    public void setDeletions(Integer deletions) {
        this.deletions = deletions;
    }

    public Integer getTotalCommentCount() {
        return totalCommentCount;
    }

    public void setTotalCommentCount(Integer totalCommentCount) {
        this.totalCommentCount = totalCommentCount;
    }

    public Integer getUnresolvedCommentCount() {
        return unresolvedCommentCount;
    }

    public void setUnresolvedCommentCount(Integer unresolvedCommentCount) {
        this.unresolvedCommentCount = unresolvedCommentCount;
    }

    public Boolean getHasReviewStarted() {
        return hasReviewStarted;
    }

    public void setHasReviewStarted(Boolean hasReviewStarted) {
        this.hasReviewStarted = hasReviewStarted;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Object> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Object> requirements) {
        this.requirements = requirements;
    }

}

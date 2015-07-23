package com.accenture.newcodington.helper;

public class DbQuery {
	// SQL queries for EVENTDAO
	public String searchEvent = "";
	public String updateEvent = "";
	public String viewEvent = "";
	public String deleteEvent = "";
	// SQL queries for VISITORDAO
	public String insertData = "";
	public String searchUser = "";
	public String registerVisitorToEvent = "";
	public String registeredEvents = "";
	public String updateVisitor = "";
	public String changePassword = "";
	public String matchWithOldPwd = "";
	public String unregisterEvent = "";
	public String getIDByUsername = "";
	public String checkUserRegistered = "";

	public String getSearchEvent() {
		return searchEvent;
	}

	public void setSearchEvent(String searchEvent) {
		this.searchEvent = searchEvent;
	}

	public String getUpdateEvent() {
		return updateEvent;
	}

	public void setUpdateEvent(String updateEvent) {
		this.updateEvent = updateEvent;
	}

	public String getViewEvent() {
		return viewEvent;
	}

	public void setViewEvent(String viewEvent) {
		this.viewEvent = viewEvent;
	}

	public String getDeleteEvent() {
		return deleteEvent;
	}

	public void setDeleteEvent(String deleteEvent) {
		this.deleteEvent = deleteEvent;
	}

	public String getInsertData() {
		return insertData;
	}

	public void setInsertData(String insertData) {
		this.insertData = insertData;
	}

	public String getSearchUser() {
		return searchUser;
	}

	public void setSearchUser(String searchUser) {
		this.searchUser = searchUser;
	}

	public String getRegisterVisitorToEvent() {
		return registerVisitorToEvent;
	}

	public void setRegisterVisitorToEvent(String registerVisitorToEvent) {
		this.registerVisitorToEvent = registerVisitorToEvent;
	}

	public String getRegisteredEvents() {
		return registeredEvents;
	}

	public void setRegisteredEvents(String registeredEvents) {
		this.registeredEvents = registeredEvents;
	}

	public String getUpdateVisitor() {
		return updateVisitor;
	}

	public void setUpdateVisitor(String updateVisitor) {
		this.updateVisitor = updateVisitor;
	}

	public String getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}

	public String getMatchWithOldPwd() {
		return matchWithOldPwd;
	}

	public void setMatchWithOldPwd(String matchWithOldPwd) {
		this.matchWithOldPwd = matchWithOldPwd;
	}

	public String getUnregisterEvent() {
		return unregisterEvent;
	}

	public void setUnregisterEvent(String unregisterEvent) {
		this.unregisterEvent = unregisterEvent;
	}

	public String getGetIDByUsername() {
		return getIDByUsername;
	}

	public void setGetIDByUsername(String getIDByUsername) {
		this.getIDByUsername = getIDByUsername;
	}

	public String getCheckUserRegistered() {
		return checkUserRegistered;
	}

	public void setCheckUserRegistered(String checkUserRegistered) {
		this.checkUserRegistered = checkUserRegistered;
	}
}

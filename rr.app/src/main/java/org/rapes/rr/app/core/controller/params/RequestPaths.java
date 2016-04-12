package org.rapes.rr.app.core.controller.params;

public class RequestPaths {

	public static final String ARTICLE_SAVE_OR_UPDATE_SERVICE="/articleSaveOrUpdate";
	public static final String ARTICLE_LOAD_PAGE_SERVICE="/articleLoadPage";
	public static final String ARTICLE_LOAD_ALL_SERVICE="/articleLoadAll";	
	public static final String ARTICLE_DELETE="/articleDelete";
	
	public static final String NOTIFICATIONS="/notifications";
	public static final String NOTIFICATIONS_SES_UUID="/notificationsSesUUID";
	public static final String NOTIFICATION_SAVE="/notificationSave";
	
	//map locations
	public static final String MAP_LOCATION_LOAD_FOR_ROUTE="/routeLoadMapLocations";
	public static final String MAP_LOCATION_SAVE_OR_UPDATE="/locationSaveOrUpdate";
	public static final String MAP_LOCATION_DELETE="/locationDelete";
	
	//map markers
	public static final String MAP_MARKERS_LOAD_FOR_ARTICLE="/markersLoadForArticle";
	public static final String MAP_MARKERS_SAVE_OR_UPDATE="/markerSaveOrUpdate";
	public static final String MAP_MARKERS_DELETE="/markerDelete";
	
	//map refferences
	public static final String MAP_REFFERENCES_LOAD_FOR_ARTICLE="/mapRefferencesLoadForArticle";
	public static final String MAP_REFFERENCES_SAVE_OR_UPDATE="/refferencesSaveOrUpdate";
	public static final String MAP_REFFERENCES_DELETE="/refferencesDelete";
	
	//map route
	public static final String MAP_ROUTE_LOAD_FOR_MAP_REFFERENCE="/mapRoutesLoadForMapRefference";
	public static final String MAP_ROUTE_SAVE_OR_UPDATE="/routeSaveOrUpdate";
	public static final String MAP_ROUTE_DELETE="/routeDelete";
}	

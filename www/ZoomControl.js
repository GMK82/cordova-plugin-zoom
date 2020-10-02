cordova.define("cordova-plugin-zoom.ZoomControl", function(require, exports, module) {
// creating plugin
var exec = require("cordova/exec");

function ZoomControl() {};

ZoomControl.prototype.zoomControl = function(enabled) {
  exec(null, function(error){
    alert("Error calling ZoomControl::ZoomControl:"+error);
  }, "ZoomControl", "zoomControl", [enabled]);
};
ZoomControl.prototype.setBuiltInZoomControls = function(enabled) {
  exec(null, function(error){
    alert("Error calling ZoomControl::setBuiltInZoomControls:"+error);
  }, "ZoomControl", "setBuiltInZoomControls", [enabled]);
};
ZoomControl.prototype.setDisplayZoomControls = function(enabled) {
  exec(null, function(error){
    alert("Error calling ZoomControl::setDisplayZoomControls:"+error);
  }, "ZoomControl", "setDisplayZoomControls", [enabled]);
};
ZoomControl.prototype.setInitialScale = function(scaleInPercent) {
  exec(null, function(error){
    alert("Error calling ZoomControl::setInitialScale:"+error);
  }, "ZoomControl", "setInitialScale", [scaleInPercent]);
};

var ZoomControl = new ZoomControl();
module.exports = ZoomControl;
});

'use strict';if(!reform){window.reform={data:{},urls:{},widgets:{}};}
reform.widgets.map={};reform.widgets.map.init=function(){var widget=reform.widgets.map;var map=widget.object=L.map('map',{center:new L.LatLng(reform.data.appreciation.latitude,reform.data.appreciation.longitude),zoom:8});L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png').addTo(map);L.marker([reform.data.appreciation.latitude,reform.data.appreciation.longitude]).addTo(map);L.control.scale().addTo(map);map.scrollWheelZoom.disable();}
$(document).ready(reform.widgets.map.init);
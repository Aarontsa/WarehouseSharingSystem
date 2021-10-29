(function () {
	/*---------------------- Specific Config ----------------------	 */
    // var DOMAIN = "http://192.168.42.175:8080";
    var DOMAIN = "http://192.168.43.20:8080";
    var HomeDomain = DOMAIN + "/WSharefyp/HomeServlet";
    var LoginDomain = DOMAIN + "/WSharefyp/LoginServlet";
    var EditDomain = DOMAIN + "/WSharefyp/EditServlet";
    var MapDomain = DOMAIN + "/WSharefyp/MapServlet";
    var StorageDomain = DOMAIN + "/WSharefyp/StorageServlet";
    var BookingDomain = DOMAIN + "/WSharefyp/BookingServlet";
    var HistoryDomain = DOMAIN + "/WSharefyp/HistoryServlet";
    var HistoryorderDomain = DOMAIN + "/WSharefyp/HistoryorderServlet";
    var RegisterDomain = DOMAIN + "/WSharefyp/RegisterServlet";
    var ChatDomain = DOMAIN + "/WSharefyp/ChatServlet";
    var Chat2Domain = DOMAIN + "/WSharefyp/Chat2Servlet";
    var ChatlistDomain = DOMAIN + "/WSharefyp/ChatlistServlet";
    var RecommandDomain = DOMAIN + "/WSharefyp/RecommandServlet";
    var ValidDomain = DOMAIN + "/WSharefyp/ValidServlet";
    var ValidchatlistDomain = DOMAIN + "/WSharefyp/ValidchatlistServlet";
    var RecommandStorageDomain = DOMAIN + "/WSharefyp/RecommandStorageServlet";
    var UseridDomain = DOMAIN + "/WSharefyp/UseridServlet";
    var ForgetpasswordsDomain = DOMAIN + "/WSharefyp/ForgetpasswordsServlet";
    var RecommandStoragerateDomain = DOMAIN + "/WSharefyp/RecommandStoragerateServlet";
    var ValidbuttonDomain = DOMAIN + "/WSharefyp/ValidbuttonServlet";
    var CommentViewDomain = DOMAIN + "/WSharefyp/CommentViewServlet";
    var ChatlistidServletDomain = DOMAIN + "/WSharefyp/ChatlistidServlet";
    var Chatuser2Domain = DOMAIN + "/WSharefyp/Chatuser2Servlet";    
    var UpdatestatusDomain = DOMAIN + "/WSharefyp/UpdatestatusServlet"; 
    var UpdatestatuslogoutDomain = DOMAIN + "/WSharefyp/UpdatestatuslogoutServlet";
    var RegistersizeDomain = DOMAIN + "/WSharefyp/RegistersizeServlet";
    var EditstorageSaveDomain = DOMAIN + "/WSharefyp/EditstorageSaveServlet";
    var AdminbookingreportDomain = DOMAIN + "/WSharefyp/AdminbookingreportServlet";
    var AdminuserreportDomain = DOMAIN + "/WSharefyp/AdminuserreportServlet";
    var ValidRatingDomain = DOMAIN + "/WSharefyp/ValidRatingServlet";
    var StorageTypeDomain = DOMAIN + "/WSharefyp/StorageTypeServlet";
    var ValidDatestatusDomain = DOMAIN + "/WSharefyp/ValidDatestatusServlet";
    var DatesshowDomain = DOMAIN + "/WSharefyp/DatesshowServlet";
    var DatesshowlDomain = DOMAIN + "/WSharefyp/DatesshowlServlet";
    var RecommandcountDomain = DOMAIN + "/WSharefyp/RecommandcountServlet";
    var RecommandStoragecountDomain = DOMAIN + "/WSharefyp/RecommandStoragecountServlet";
    var RecommandresultcountDomain = DOMAIN + "/WSharefyp/RecommandresultcountServlet";
    var AdminusergraphDomain = DOMAIN + "/WSharefyp/AdminusergraphServlet";
    var UsergraphDomain = DOMAIN + "/WSharefyp/UsergraphServlet";
    var UsergraphorderDomain = DOMAIN + "/WSharefyp/UsergraphorderServlet";
    var UpdatemessagestatusDomain = DOMAIN + "/WSharefyp/UpdatemessagestatusServlet";
    var ChaticonDomain = DOMAIN + "/WSharefyp/ChaticonServlet";
    var ChatnaviiconDomain = DOMAIN + "/WSharefyp/ChatnaviiconServlet";
    var AdminDeletebookingDomain = DOMAIN + "/WSharefyp/AdminDeletebookingServlet";
    var AdminEditDomain = DOMAIN + "/WSharefyp/AdminEditServlet";
    
    // storage for temporary
    var Username2 = localStorage.getItem("Username11");
    var Passwords2 = localStorage.getItem("Passwords11");
    var Storage_Username2 = localStorage.getItem("Storage_Username");
    var CStorage_Userid2 = localStorage.getItem("CStorage_Userid");
    var Chatlist_id2 = localStorage.getItem("Chatlist_id");
    var Chatlistid2 = localStorage.getItem("Chatlistid");

	/* ---------------------- Local Variables ------------------------ */
    HomeView.prototype.template = Handlebars.compile($("#Home").html());
    LoginView.prototype.template = Handlebars.compile($("#Login").html());
    RegisterView.prototype.template = Handlebars.compile($("#Register").html());
    EditView.prototype.template = Handlebars.compile($("#Edit").html());
    MapView.prototype.template = Handlebars.compile($("#Map").html());
    StorageView.prototype.template = Handlebars.compile($("#Storage").html());
    BookingView.prototype.template = Handlebars.compile($("#Booking").html());
    HistoryView.prototype.template = Handlebars.compile($("#History").html());
    ChatView.prototype.template = Handlebars.compile($("#Chat").html());
    Chat2View.prototype.template = Handlebars.compile($("#Chat2").html());
    ChatlistView.prototype.template = Handlebars.compile($("#Chatlist").html());
    RecommandView.prototype.template = Handlebars.compile($("#Recommand").html());
    AboutView.prototype.template = Handlebars.compile($("#About").html());
    ForgetpasswordsView.prototype.template = Handlebars.compile($("#Forgetpasswords").html());
    ReportView.prototype.template = Handlebars.compile($("#Report").html());
    ReportUserView.prototype.template = Handlebars.compile($("#ReportUser").html());
    LogoutView.prototype.template = Handlebars.compile($("#Logout").html());
    AdminEditView.prototype.template = Handlebars.compile($("#AdminEdit").html());
    
    // *** Home *** //
    router.addRoute('', function () {
        $('body').html(new HomeView().render().$el);
        $('body').scrollTop(0);
                
        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                // Portrait viewportHeight
                // popup
                $("#popupWrongPassword").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupWrongPassword").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupWrongPassword").width() / 2) + 'px'
                });
                $("#popUpInsertPassword").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popUpInsertPassword").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popUpInsertPassword").width() / 2) + 'px'
                });
            } if (viewportHeight < viewportWidth) {
                // Landscape
                // popup
                $("#popupWrongPassword").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupWrongPassword").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupWrongPassword").width() / 2) + 'px'
                });
                $("#popUpInsertPassword").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popUpInsertPassword").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popUpInsertPassword").width() / 2) + 'px'
                });
            }
        }).resize();

        // close popup button
        $("#btnCloseAlertWrongPassword").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertWrongPassword") {
                $("#popupAlertWrongPassword").hide();
            }
        });

        $("#btnCloseAlertInsertPassword").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertInsertPassword") {
                $("#popUpAlertInsertPassword").hide();
            }
        });

        // hide popupAlert
        $("#popupAlertWrongPassword").hide();
        $("#popUpAlertInsertPassword").hide();

        // navigate to Selection page
        $("#Registerbutton").click(function () {
            window.location.href = "#Register";
        });

        // navigate to Selection page
        $("#forgetpasswordsbutton").click(function () {
            window.location.href = "#Forgetpasswords";
        });

        // login check
        $('#Loginbutton').click(function () {
            {
                var Username = $('#Username').val();
                var Passwords = $('#Passwords').val();
                if (Username == "" || Passwords == "") {
                    $("#popUpAlertInsertPassword").show();
                    return false;
                }
                $.ajax({
                    // dataType: "text",
                    type: "POST",
                    url: HomeDomain,
                    data: { "Username": Username, "Passwords": Passwords },
                    success: function (data) {
                        // var result = $.trim(data);
                        if (data) {
                            // alert("Data: " + data);
                            $("#popupAlertWrongPassword").show();
                            // return false;
                        } else {
                        	
                            $.ajax({
                                // dataType: "text",
                                type: "POST",
                                url: UpdatestatusDomain,
                                data: { "Username": Username, "Passwords": Passwords, "User_Status": '1' },
                                success: function (data) {
                                    // var result = $.trim(data);
                                  var Username1 = document.getElementById("Username").value;
                                  localStorage.setItem("Username11", Username1);
                                  // alert(Username1);
                                  var Passwords1 = document.getElementById("Passwords").value;
                                  localStorage.setItem("Passwords11", Passwords1);
                                  // alert(Passwords1);
                                  window.location.href = "#Login";
                                  // return false;
                                }
                            });
                        	
                        }
                    }
                });
            }
        });

    });

    // *** Login *** //
    router.addRoute('Login', function () {// X
        $('body').html(new LoginView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {
                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            closeNav();
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });

        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });
        
        $("#GoReportbutton").click(function () {
            window.location.href = "#Report";
        });
        
        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });
                
        // navigate to map page
        $("#Gomapbutton").click(function () {
            window.location.href = "#Map";
        });

        $("#GoReportbutton").hide();
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });
        
        // get today order data from database
        $.ajax({
            type: "GET",
            url: LoginDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) {

                $('#Todayhistory').append(result);
                // initialize();
                // go report button
                $(document).ready(function () {
                    if($("#Username").val() == "admin" || $("#Username").val() == "Admin" || $("#Username").val() == "ADMIN"){
                    	$("#GoReportbutton").show();
                    }
                    });
            }
        });

        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        // get containt from home page for input
        document.getElementById('Passwords').value = localStorage.getItem('Passwords11');
        document.getElementById('Username').value = localStorage.getItem('Username11');
    });

    // *** Register *** //
    router.addRoute('Register', function () {
        $('body').html(new RegisterView().render().$el);
        $('body').scrollTop(0);


        // hide and show radiobutton
        $("#storage").click(function () {
            var id = $(this).attr("id");
            if (id == "storage") {
            	$("#ifstorage").show();
            }
        });
        
        $("#nostorage").click(function () {
            var id = $(this).attr("id");
            if (id == "nostorage") {
            	$("#ifstorage").hide();
            }
        });
        
        $("#male").click(function () {
            var id = $(this).attr("id");
            if (id == "male") {
                $("#image-holder2").show();
                $("#image-holder1").hide();
                $("#image-holder3").hide();
                $("#female").prop('checked', false).val(0);
            }
        });

        $("#female").click(function () {
            var id = $(this).attr("id");
            if (id == "female") {
                $("#image-holder3").show();
                $("#image-holder2").hide();
                $("#image-holder1").hide();
                $("#male").prop('checked', false).val(0);
            }
        });

        // hide and show radiobutton
        $("#nostorage").click(function () {
            var id = $(this).attr("id");
            if (id == "nostorage") {
                $("#storage").prop('checked', false).val(0);
            }
        });

        $("#storage").click(function () {
            var id = $(this).attr("id");
            if (id == "storage") {
                $("#nostorage").prop('checked', false).val(0);
            }
        });
        
        $(document).ready(function () {
            initialize();
        });

        // hide image
        $("#image-holder2").hide();
        $("#image-holder3").hide();
        $("#ifstorage").hide();

        // hide popupAlert
        $("#popupAlertloginagain").hide();
        $("#popupAlerincomplete").hide();
        $("#popupAlernotavalaiblename").hide();
        $("#popupAlernolocation").hide();

        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
                $("#popupNotavalaiblename").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupNotavalaiblename").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupNotavalaiblename").width() / 2) + 'px'
                });
                $("#popupnolocation").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupnolocation").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupnolocation").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
                $("#popupNotavalaiblename").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupNotavalaiblename").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupNotavalaiblename").width() / 2) + 'px'
                });
                $("#popupnolocation").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupnolocation").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupnolocation").width() / 2) + 'px'
                });
            }
        }).resize();

        // close popup button X
        $("#btnCloseAlertIncomplete").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertIncomplete") {
                $("#popupAlerincomplete").hide();
                $("#popupAlernolocation").hide();
            }
        });
        
        $("#btnCloseAlertNotavalaiblename").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertNotavalaiblename") {
                $("#popupAlernotavalaiblename").hide();
            }
        });
        
        $("#btnCloseAlertnolocation").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertnolocation") {
                $("#popupAlernolocation").hide();
            }
        });

        // navigate to home page
        $("#backbutton").click(function () {
            window.location.href = "#";
        });

        // get lat and lng for post
        $('#Registerbutton').click(function () {
            codeAddress();
            {
                if (

                    checkCheckboxInput("nostorage") == ""
                    && checkCheckboxInput("storage") == ""
                    || checkCheckboxInput("male") == ""
                    && checkCheckboxInput("female") == ""
                    || $('#Username').val() == ""
                    || $('#Passwords').val() == ""
                    || $('#Email').val() == ""
                    || $('#Mobilenumber').val() == ""
                    || $('#Address').val() == ""
                    || $('#Description').val() == ""

                ) {
// alert("insert");
                    $("#popupAlerincomplete").show();
                    return false;
                } 
                if($('#Username').val() != ""){
                $.ajax({
                    // dataType: "text",
                    type: "POST",
                    url: ValidDomain,
                    data: { "Username": $('#Username').val() },
                    success: function (data) {
                        // var result = $.trim(data);
                        if (data) {
                        	$("#popupAlernotavalaiblename").show();
// alert("username is not avalaible");
                            return false;
                        } else {

                            $("#popupAlertloginagain").show();
                             console.log("V");
                        }
                    }
                });
                }
            }
        });

        // post and connect to database for register
        $('#btnClosepoploginagain').click(function () {

            $.post(RegisterDomain,
                {
                    img: $('input[name="img"]:checked').val(),
                    usertype: $('input[name="usertype"]:checked').val(),
                    Username: $('#Username').val(),
                    Passwords: $('#Passwords').val(),
                    Email: $('#Email').val(),
                    Mobilenumber: $('#Mobilenumber').val(),
                    Address: $('#Address').val(),
                    Description: $('#Description').val(),
                    latitude: $('#lat').val(),
                    longtitude: $('#lng').val()

                })

                .done(function () {
                	console.log($('input[name="img"]:checked').val());
                    $.ajax({
                        // dataType: "text",
                        type: "POST",
                        url: RegistersizeDomain,
                        data: { "Username": $('#Username').val(), "Passwords": $('#Passwords').val(), "Storage_size": $('input[name="Storagesize"]:checked').val() },
                        success: function (data) {

                            $("#popupAlertloginagain").hide();
                            window.location.href = "#";

                        }
                    });               	
                    // alert("submited");
                })
                .fail(function (ex) {
                    // alert(ex);
                });

        });

        // key in number only
        $('#Mobilenumber').bind('keyup paste', function () {
            var thisnumber = $(this);
            var valuenumber = thisnumber.val();
            var notNumber = new RegExp("[^0-9]", "g");
            this.value = this.value.replace(/[^0-9]/g, '');
        });

        // function to check checkbox
        function checkCheckboxInput(answer) {
            if ($('input[id="' + answer + '"]:checked').length > 0) {

                return true;
            } else {
                return false;
            }
        }

        // show place when search
        var geocoder;
        var map;
        function initialize() {
            geocoder = new google.maps.Geocoder();
            var latlng = new google.maps.LatLng(1.5533, 110.3592);
            var mapOptions = {
                zoom: 6,
                center: latlng
            }
            map = new google.maps.Map(document.getElementById('map'), mapOptions);

            // create marker and infowindow
            var marker;
            var infowindow;
            marker = new google.maps.Marker({
                position: { lat: 1.4649, lng: 110.4269 },
                map: map,
                icon: './img/hut.png',
                title: 'storage'
            });

            // marker.setMap(map);

            infowindow = new google.maps.InfoWindow({
                content: contentString
            });
            // infowindows's content
            var contentString = '<div>' +
                '<div id="Visitbutton" class="Visitbutton" type="submit" value="Visit"><a ></a>Visit</div>' +
                '</div>';

            marker.addListener('click', function () {
                infowindow.setContent(contentString);
                infowindow.open(map, marker);
            });       
            

        }

        // get latitude and longtitude
        function codeAddress() {
            var address = document.getElementById('Address').value;
            geocoder.geocode({ 'address': address }, function (results, status) {
                if (status == 'OK') {
                    map.setCenter(results[0].geometry.location);
                    var marker = new google.maps.Marker({
                        map: map,
                        positionlat: results[0].geometry.location.lat(),
                        positionlng: results[0].geometry.location.lng(),
                        position: { lat: results[0].geometry.location.lat(), lng: results[0].geometry.location.lng()},
                        icon: './img/hut.png',
                        title: 'storage',
// draggable: true

                    });
                    document.getElementById('lat').value = marker.positionlat;
                    document.getElementById('lng').value = marker.positionlng;
                    // alert(marker.position);
                    if (results[0].geometry.viewport)
                        map.fitBounds(results[0].geometry.viewport);
// $("#popupAlertloginagain").show();
                } else {
                	$("#popupAlernolocation").show();
                    console.log('Geocode was not successful for the following reason: ' + status);
                    
                }
                
                google.maps.event.addListener(map, 'click', function(event) {
                	console.log(marker.positionlat());
                    var result = [event.position.lat(), event.position.lng()];
                    console.log(result);
                    transition(result);
                });

            });
        }
        
        var numDeltas = 100;
        var delay = 10; // milliseconds
        var i = 0;
        var deltaLat;
        var deltaLng;

        function transition(result){
            i = 0;
            deltaLat = (result[0] - position[0])/numDeltas;
            deltaLng = (result[1] - position[1])/numDeltas;
            moveMarker();
        }

        function moveMarker(){
            position[0] += deltaLat;
            position[1] += deltaLng;
            var latlng = new google.maps.LatLng(results[0].geometry.location.lat(), results[0].geometry.location.lng());
            marker.setTitle("Latitude:"+results[0].geometry.location.lat()+" | Longitude:"+results[0].geometry.location.lng());
            marker.setPosition(latlng);
            if(i!=numDeltas){
                i++;
                setTimeout(moveMarker, delay);
            }
        }

    });

    // *** Edit *** //
    router.addRoute('Edit', function () {
        $('body').html(new EditView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });
        
        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });

        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });

        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        // hide popupAlert
        $("#popupAlertloginagain").hide();
        $("#popupAlerincomplete").hide();
        $("#popupAlernolocation").hide();
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });

        // get user data from database
        $(document).ready(function () {
        $.ajax({
            type: "GET",
            url: EditDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) {

                $('#editform').append(result);
                console.log("see-"+localStorage.getItem('Passwords11'));
// $("#ifstorage").hide();
                // alert(result);
                // img check
                if ($('input[name="userimg"]').val() == "male") {
                    $('#image-holder3').hide();
                    // $("#female").prop('checked', true).val(1);
                    $('input[name="img"][value="male"]').prop('checked', true);
                }
                if ($('input[name="userimg"]').val() == "female") {
                    $('#image-holder2').hide();
                    $('input[name="img"][value="female"]').prop('checked', true);
                }
                // type check
                if ($('input[name="usercatogery"]').val() == "storage") {
                    $('input[name="usertype"][value="storage"]').prop('checked', true);
                    $("#ifstorage").show();
                }
                if ($('input[name="usercatogery"]').val() == "nostorage") {
                    $('input[name="usertype"][value="nostorage"]').prop('checked', true);
                    $("#ifstorage").hide();
                }
                if ($('input[name="Storage_size"]').val() == "Small(50cmx50cm)") {
                    $('input[name="Storagesize"][value="Small(50cmx50cm)"]').prop('checked', true);
                }
                if ($('input[name="Storage_size"]').val() == "Large(100cmx100cm)") {
                    $('input[name="Storagesize"][value="Large(100cmx100cm)"]').prop('checked', true);
                }
                initialize();

                // key in number only
                $('#Mobilenumber').bind('keyup paste', function () {
                    var thisnumber = $(this);
                    var valuenumber = thisnumber.val();
                    var notNumber = new RegExp("[^0-9]", "g");
                    this.value = this.value.replace(/[^0-9]/g, '');

                });
            }
        });
        });

        // hide and show radiobutton
        $(document.body).on('click', '#storage', function () {
            var id = $(this).attr("id");
            if (id == "storage") {
            	$("#ifstorage").show();
            }
        });
        
        $(document.body).on('click', '#nostorage', function () {
            var id = $(this).attr("id");
            if (id == "nostorage") {
            	$("#ifstorage").hide();
            }
        });
        
        // hide and show radiobutton
        $(document.body).on('click', '#male', function () {
            var id = $(this).attr("id");
            if (id == "male") {
                $("#image-holder2").show();
                $("#image-holder1").hide();
                $("#image-holder3").hide();
                $("#female").prop('checked', false).val(0);
            }
        });

        $(document.body).on('click', '#female', function () {
            var id = $(this).attr("id");
            if (id == "female") {
                $("#image-holder3").show();
                $("#image-holder2").hide();
                $("#image-holder1").hide();
                $("#male").prop('checked', false).val(0);
            }
        });

        $(document).ready(function () {
            $("#userimg").hide();
        });

        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
                $("#popupnolocation").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupnolocation").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupnolocation").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
                $("#popupnolocation").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupnolocation").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupnolocation").width() / 2) + 'px'
                });
            }
        }).resize();

        // close popup button X
        $("#btnClosepoploginagain").click(function () {
            var id = $(this).attr("id");
            if (id == "btnClosepoploginagain") {
                $("#popupAlertloginagain").hide();
                // window.location.href = "#";
            }
        });
        
        $("#btnCloseAlertIncomplete").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertIncomplete") {
                $("#popupAlerincomplete").hide();
            }
        });
        
        $("#btnCloseAlertnolocation").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertnolocation") {
                $("#popupAlernolocation").hide();
            }
        });

        // navigate to home page
        $(document.body).on('click', '#backbutton', function () {
            window.location.href = "#Login";
        });

        // get lat and lng and check
        $(document.body).on('click', '#Saveeditbutton', function () {
            codeAddress();

            if (
                checkCheckboxInput("nostorage") == ""
                && checkCheckboxInput("storage") == ""
                || checkCheckboxInput("male") == ""
                && checkCheckboxInput("female") == ""
                || $('#Username').val() == ""
                || $('#Passwords').val() == ""
                || $('#Email').val() == ""
                || $('#Mobilenumber').val() == ""
                || $('#Address').val() == ""
                || $('#Description').val() == ""
            ) {
// alert("insert");
                $("#popupAlerincomplete").show();
                return false;
            } else {
            	console.log("not empty");
// $("#popupAlertloginagain").show();
            }

        });

        // post update
        $('#btnClosepoploginagain').click(function () {

            document.getElementById('CPasswords').value = localStorage.getItem('Passwords11');
            document.getElementById('CUsername').value = localStorage.getItem('Username11');

            $.post(EditDomain,
                {

                    CUsername: $('#CUsername').val(),
                    CPasswords: $('#CPasswords').val(),
                    img: $('input[name="img"]:checked').val(),
                    usertype: $('input[name="usertype"]:checked').val(),
                    Username: $('#Username').val(),
                    Passwords: $('#Passwords').val(),
                    Email: $('#Email').val(),
                    Mobilenumber: $('#Mobilenumber').val(),
                    Address: $('#Address').val(),
                    Description: $('#Description').val(),
                    latitude: $('#lat').val(),
                    longtitude: $('#lng').val()

                })

                .done(function () {
                	
                    $.ajax({
                        // dataType: "text",
                        type: "POST",
                        url: EditstorageSaveDomain,
                        data: { "CUsername": $('#CUsername').val(), "CPasswords": $('#CPasswords').val(), "Storage_size": $('input[name="Storagesize"]:checked').val() },
                        success: function (data) {

                        	localStorage.removeItem("Passwords2");
                            var Passwords2 = document.getElementById("Passwords").value;
                            console.log(Passwords2);
                            localStorage.setItem("Passwords11", document.getElementById("Passwords").value);
// console.log("aaaa-"+$('input[name="Storagesize"]:checked').val());
                        	console.log("successful save");
// location.reload();
                            window.location.href = "#Login";                        	

                        }
                    });
// alert("submited");
                })
                .fail(function (ex) {
                    alert(ex);
                });
        });

        // function to check checkbox
        function checkCheckboxInput(answer) {
            if ($('input[id="' + answer + '"]:checked').length > 0) {
                return true;
            } else {
                return false;
            }
        }

        // show place when search
        var geocoder;
        var map;
        function initialize() {
            geocoder = new google.maps.Geocoder();
            var latlng = new google.maps.LatLng(1.5533, 110.3592);
            var mapOptions = {
                zoom: 6,
                center: latlng
            }
            map = new google.maps.Map(document.getElementById('map'), mapOptions);

            // create marker and infowindow
            var marker;
            var infowindow;
            marker = new google.maps.Marker({
                position: { lat: 1.4649, lng: 110.4269 },
                map: map,
                icon: './img/hut.png',
                title: 'storage'
            });

            // marker.setMap(map);

            infowindow = new google.maps.InfoWindow({
                content: contentString
            });
            // infowindows's content
            var contentString = '<div>' +
                '<div id="Visitbutton" class="Visitbutton" type="submit" value="Visit"><a ></a>Visit</div>' +
                '</div>';

            marker.addListener('click', function () {
                infowindow.setContent(contentString);
                infowindow.open(map, marker);
            });

        }

        // get latitude and longtitude
        function codeAddress() {
            var address = document.getElementById('Address').value;
            geocoder.geocode({ 'address': address }, function (results, status) {
                if (status == 'OK') {
                    map.setCenter(results[0].geometry.location);
                    var marker = new google.maps.Marker({
                        map: map,
                        positionlat: results[0].geometry.location.lat(),
                        positionlng: results[0].geometry.location.lng()

                    });
                    document.getElementById('lat').value = marker.positionlat;
                    document.getElementById('lng').value = marker.positionlng;
                    // alert(marker.position);
                    if (results[0].geometry.viewport)
                        map.fitBounds(results[0].geometry.viewport);
                    $("#popupAlertloginagain").show();
                } else {
                	$("#popupAlernolocation").show();
                    console.log('Geocode was not successful for the following reason: ' + status);
                }
            });
        }

    });


    // *** Map *** //
    router.addRoute('Map', function () {
        $('body').html(new MapView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
        	closeNav();
//            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });

        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });
        
        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });
        
        // hide
        $("#popupAlernolocation").hide();
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });
        
        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#popupnolocation").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupnolocation").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupnolocation").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#popupnolocation").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupnolocation").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupnolocation").width() / 2) + 'px'
                });
            }
        }).resize();

        // close popup button X
        $("#btnCloseAlertnolocation").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertnolocation") {
                $("#popupAlernolocation").hide();
            }
        });


        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        $(document).ready(function () {
            initialize();
            // Multimarker();
        });

        // $(document).ready(function () {
        // navigate to search place
        $("#Searchbutton").click(function () {
        	
            codeAddress();
        });

        $(document).ready(function () {
            // navigate to Selection page
            $("#Recommandationbutton").click(function () {
                window.location.href = "#Recommand";
            });
        });

        $(document).ready(function () {
            // navigate to Selection page
            $("#backbutton").click(function () {
                window.location.href = "#Login";
            });
        });

        $(document.body).on('click', '#Visitbutton', function () {
            var Storage_Username = document.getElementById("Storage_Username").value;
            localStorage.setItem("Storage_Username", Storage_Username);
            // alert(Storage_Username);
            var CStorage_Userid = document.getElementById("CStorage_Userid").value;
            localStorage.setItem("CStorage_Userid", CStorage_Userid);
            // alert(Storage_Userid);
            var url = "#Storage";
            window.location.href = url;
        });

        var geocoder;
        var map;
        function initialize() {
            geocoder = new google.maps.Geocoder();
            var latlng = new google.maps.LatLng(1.4599, 110.4883);
            var mapOptions = {
                zoom: 13,
                center: latlng
            }
            map = new google.maps.Map(document.getElementById('map'), mapOptions);
        }

        $.ajax({   
            type: "GET",
            url: MapDomain,
            dataType: "json",  
            success: function (data) {
                // alert(data);
                var listmarker = jQuery.parseJSON(data);
                 console.log(listmarker);
                // function Multimarker(){
                var marker;
                var i;
                for (i = 0; i < listmarker.length; i++) {

                    marker = new google.maps.Marker({
                        position: { lat: (parseFloat(listmarker[i][2])), lng: (parseFloat(listmarker[i][3])) },
                        map: map,
                        icon: './img/hut.png',
                        title: 'storage',
                        visible: true
                    });

                    var infowindow = new google.maps.InfoWindow({
                        content: contentString
                    });

                    // infowindows
                    var contentString = '<div>' +
                    	'<p>Storage name:' + listmarker[i][1] + '</p>' +
                        '<div id="Visitbutton" class="Visitbutton" type="submit" value="Visit"><a ></a>Visit</div>' +
                        '<input type="hidden" id="Storage_Username" value="' + listmarker[i][1] + '">' +
                        '<input type="hidden" id="CStorage_Userid" value="' + listmarker[i][0] + '">' +
                        '</div>';

                    google.maps.event.addListener(marker, 'click', (function (marker, contentString) {
                        return function () {
                            infowindow.setContent(contentString);
                            infowindow.open(map, marker);
                        }
                    })(marker, contentString));
                }
            }
        });

        function codeAddress() {
            var address = document.getElementById('pac-input').value;
            geocoder.geocode({ 'address': address }, function (results, status) {
                if (status == 'OK') {
                    map.setCenter(results[0].geometry.location);
                    var marker = new google.maps.Marker({
                        map: map,
                        positionlat: results[0].geometry.location.lat(),
                        positionlng: results[0].geometry.location.lng(),
// position: { lat: results[0].geometry.location.lat(), lng:
// results[0].geometry.location.lng()}
                    });
                    // document.getElementById('lat').value=marker.positionlat;
                    // document.getElementById('lng').value=marker.positionlng;
                    // alert(marker.position);
                    if (results[0].geometry.viewport) {
                        map.fitBounds(results[0].geometry.viewport);
                    }
                } else {
                	$("#popupAlernolocation").show();
                    console.log('error: ' + status);
                }
            });
        }

        // get containt from home page for input
        document.getElementById('Passwords').value = localStorage.getItem('Passwords11');
        document.getElementById('Username').value = localStorage.getItem('Username11');

    });

    // *** Storage *** //
    router.addRoute('Storage', function () {
        $('body').html(new StorageView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });
        
        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });

        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });

        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        // location.reload();

        // get containt from home page for input
        document.getElementById('Passwords').value = localStorage.getItem('Passwords11');
        document.getElementById('Username').value = localStorage.getItem('Username11');
        document.getElementById('Storage_Username').value = localStorage.getItem('Storage_Username');
        document.getElementById('CStorage_Userid').value = localStorage.getItem('CStorage_Userid');

        // get storage data from database
        $.ajax({
            type: "GET",
            url: StorageDomain,
            data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid') },
            success: function (result) {

                $('#Storageform').append(result);
                if ($('input[name="fileUpload1"]').val() == "male") {
                    $('#image-holder3').hide();
                } else if ($('input[name="fileUpload1"]').val() == "female") {
                    $('#image-holder2').hide();
                }

                if ($('#storagerating').val() <= "1") {
                    $('input[name="rg5"][value="5"]').prop('checked', true);
                } else
                    if ($('#storagerating').val() <= "2") {
                        $('input[name="rg5"][value="5"]').prop('checked', true);
                        $('input[name="rg4"][value="4"]').prop('checked', true);
                    } else
                        if ($('#storagerating').val() <= "3") {
                            $('input[name="rg5"][value="5"]').prop('checked', true);
                            $('input[name="rg4"][value="4"]').prop('checked', true);
                            $('input[name="rg3"][value="3"]').prop('checked', true);
                        } else
                            if ($('#storagerating').val() <= "4") {
                                $('input[name="rg5"][value="5"]').prop('checked', true);
                                $('input[name="rg4"][value="4"]').prop('checked', true);
                                $('input[name="rg3"][value="3"]').prop('checked', true);
                                $('input[name="rg2"][value="2"]').prop('checked', true);
                            } else
                                if ($('#storagerating').val() <= "5") {
                                    $('input[name="rg1"][value="1"]').prop('checked', true);
                                    $('input[name="rg2"][value="2"]').prop('checked', true);
                                    $('input[name="rg3"][value="3"]').prop('checked', true);
                                    $('input[name="rg4"][value="4"]').prop('checked', true);
                                    $('input[name="rg5"][value="5"]').prop('checked', true);
                                }
                // alert($('#fileUpload').val());
            }
        });
        
        // get comment data from database
        $.ajax({
            type: "GET",
            url: CommentViewDomain,
            data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid') },
            success: function (result) {
            	 $('#Commentview').append(result);
            	
            }
        });

        // navigate to whatsapp page
        $(document.body).on('click', '#whatsapp', function () {
            window.location.href = "https://api.whatsapp.com/send?phone=60" + $("#Mobilenumberwa").val();
        });

        // check chat list new or not
        $(document.body).on('click', '#Chatbutton', function () {
            {
                $.ajax({
                    // dataType: "text",
                    type: "POST",
                    url: ValidchatlistDomain,
                    data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "CStorage_Userid": localStorage.getItem('CStorage_Userid') },
                    success: function (data) {
                        // var result = $.trim(data);
                        if (data) {
                            console.log("Xgot: new chat");
                            $.post(ChatlistDomain,
                                {
                                    CUsername: $('#Username').val(),
                                    CPasswords: $('#Passwords').val(),
                                    UserS_id: $('#CStorage_Userid').val(),
                                })
                                .done(function () {
                                    console.log("create for new chat list");
                                             // get data from database
                                     $.ajax({
                                         type: "GET",
                                         url: ChatlistidServletDomain,
                                         data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "CStorage_Userid": localStorage.getItem('CStorage_Userid') },
                                         success: function (result) {
                                             $('#Chatlist_id').append(result);
                                             var Chatlistid = document.getElementById("Chatlistid").value;
// console.log(Chatlistid);
                                             localStorage.setItem("Chatlistid", Chatlistid);
                                             
                                             var url = "#Chat";
                                             window.location.href = url;
                                         }
                                     });


                                })
                                .fail(function (ex) {
                                    alert(ex);
                                });

                        } else {
                            console.log("got: old chat");
                            $.ajax({
                                type: "GET",
                                url: ChatlistidServletDomain,
                                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "CStorage_Userid": localStorage.getItem('CStorage_Userid') },
                                success: function (result) {
                                    $('#Chatlist_id').append(result);
                                    var Chatlistid = document.getElementById("Chatlistid").value;
// console.log(Chatlistid);
                                    localStorage.setItem("Chatlistid", Chatlistid);
                                    var Chatlistid2 = localStorage.getItem("Chatlistid");
// console.log(Chatlistid2);
                                    var url = "#Chat";
                                    window.location.href = url;
                                }
                            });
                        }
                    }
                });
            }
        });

        // hide
        $("#popupAlerfull").hide();
        $("#popupAlertcopy").hide();
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });
        
        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#popupFull").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupFull").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupFull").width() / 2) + 'px'
                });
                $("#popupcopy").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupcopy").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupcopy").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#popupFull").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupFull").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupFull").width() / 2) + 'px'
                });
                $("#popupcopy").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupcopy").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupcopy").width() / 2) + 'px'
                });
            }
        }).resize();

        // close popup button X
        $("#btnCloseAlertFull").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertFull") {
                $("#popupAlerfull").hide();
            }
        });
        
        $("#btnCloseAlertcopy").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertcopy") {
                $("#popupAlertcopy").hide();
            }
        });

        // full or not for booking if >3
        $(document.body).on('click', '#Bookbutton', function () {
//        	if($("#space").val()>='2'|| $("#space1").val()>='1'){ 
//        		$("#popupAlerfull").show();
//        	}
//        	else{
            var url = "#Booking";
            window.location.href = url;
//            }
        });
        
        // navigate to home page
        $(document.body).on('click', '#backbutton', function () {
            var url = "#Map";
            window.location.href = url;
            location.reload();
        });

        // copy address
        $(document.body).on('click', '#Copyaddressbutton', function () {
            var clipboardText = "";
            clipboardText = $('#Homeaddress').val();
            copyToClipboard(clipboardText);
            $("#popupAlertcopy").show();
// alert("Copied to Clipboard");
        });

        // copy mobile number
        $(document.body).on('click', '#Copymobilenumberbutton', function () {
            var clipboardText = "";
            clipboardText = $('#Mobilenumber').val();
            copyToClipboard(clipboardText);
            $("#popupAlertcopy").show();
// alert("Copied to Clipboard");
        });

        function copyToClipboard(text) {
            var textArea = document.createElement("textarea");
            textArea.value = text;
            document.body.appendChild(textArea);
            textArea.select();

            try {
                var successful = document.execCommand('copy');
                var msg = successful ? 'successful' : 'unsuccessful';
                console.log('Copying text command was ' + msg);
            } catch (err) {
                console.log('Oops, unable to copy');
            }

            document.body.removeChild(textArea);
        }
    });

    // *** Booking *** //
    router.addRoute('Booking', function () {// X
        $('body').html(new BookingView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });
        
        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });

        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });

        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        // get containt from home page for input
        document.getElementById('Passwords').value = localStorage.getItem('Passwords11');
        document.getElementById('Username').value = localStorage.getItem('Username11');
        document.getElementById('Storage_Username').value = localStorage.getItem('Storage_Username');
        document.getElementById('CStorage_Userid').value = localStorage.getItem('CStorage_Userid');

        // get all storage from database
        $.ajax({
            type: "POST",
            url: StorageTypeDomain,
            data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid') },
            success: function (result) {
                if(result){   
                $("select#boksize option[value='Large']").hide();}
            }
        });
        
        // hide button
        $("#SumbitbuttonMaybank").hide();
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });

        // change button to hide
        $("select#Onlinebank").on("change", function () {
            if ($('select#Onlinebank').val() == 'CIMB') {
                $("#SumbitbuttonCIMB").show();
                $("#SumbitbuttonMaybank").hide();
            } 
            if ($('select#Onlinebank').val() == 'Maybank') {
                $("#SumbitbuttonCIMB").hide();
                $("#SumbitbuttonMaybank").show();
            }
        });

        // navigate to home page
        $("#backbutton1").click(function () {
            window.location.href = "#Storage";
            location.reload();
        });
        
        // change storage price
        $("select#boksize").on("change", function () {
            if ($('select#boksize').val() == 'Small') {
            	document.getElementById("Pricestorage").value = "1";
            } 
            if ($('select#boksize').val() == 'Large') {
            	document.getElementById("Pricestorage").value = "2";
            } 
        });

        // cont days diff and price
        function GetDays() {
            var dropdt = new Date(document.getElementById("Checkout").value);
            var pickdt = new Date(document.getElementById("Checkin").value);
            var storageprice = document.getElementById("Pricestorage").value;
            var quan = document.getElementById("Quantity").value;
            var days = (dropdt - pickdt) / (24 * 3600 * 1000);
            var dayplus1 = days + 1
            return parseInt(quan * dayplus1* storageprice);
        }


        function cal() {
            if (document.getElementById("Checkin")) {
                document.getElementById("days").value = GetDays() / document.getElementById("Quantity").value;
                document.getElementById("Price").value = GetDays();
            }
        }

        // SumbitbuttonCIMB popup
        $(document).ready(function () {
            $("#SumbitbuttonCIMB").click(function () {
                // get all storage from database
                $.ajax({
                    type: "GET",
                    url: ValidDatestatusDomain,
                    data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid'), "Checkin": $('#Checkin').val(), "Checkout": $('#Checkout').val() },
                    success: function (result) {
                  	  $("#ValidDatestatus").html("");
                        $('#ValidDatestatus').append(result);
// console.log("insert1");
                cal();
                // $("#popupAlertSubmitCIMB").show();
                var a = $('#Price').val()
                $('#Price1').val("RM"+a);
                if (

                    $('#Name').val() == ""
                    || $('#Quantity').val() == ""
                    || $('#Description').val() == ""
                    || $('#Mobilenumber').val() == ""
                    || $('#Checkin').val() == ""
                    || $('#Checkout').val() == ""
                    || $('#Price').val() == ""
                    || $('#days').val() <= 0
                    || $('#Onlinebank :selected').val() == ""
                    || $('#boksize :selected').val() == ""
                ) {
                	if($('#days').val() <= 0){
                		$("#popupAlerincomplete1").show();
                	} else {
                		$("#popupAlerincomplete").show();
                	}
// console.log("insert");                  
                    return false;
                } else {
                	if($('#datecounts').val() >= '2'||$('#datecountl').val() >= '1'){
                		
                        if ($('select#boksize').val() == 'Small') {
                            // get all storage from database
                            $.ajax({
                                type: "GET",
                                url: DatesshowDomain,
                                data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid'), "Checkin": $('#Checkin').val(), "Checkout": $('#Checkout').val() },
                                success: function (result) {
                           		  $("#showdate").html("");
                                    $('#showdate').append(result);
                                  // full and show date
                                    $("#popupAlerfull").show();
                                }
                            });
                        } 
                        if ($('select#boksize').val() == 'Large') {
                            // get all storage from database
                            $.ajax({
                                type: "GET",
                                url: DatesshowlDomain,
                                data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid'), "Checkin": $('#Checkin').val(), "Checkout": $('#Checkout').val() },
                                success: function (result) {
                           		  $("#showdate1").html("");
                                    $('#showdate1').append(result);
                                  // full and show date
                                    $("#popupAlerfull1").show();
                                }
                            });
                        }

                	} else{
                		$("#popupAlertSubmitCIMB").show();
                	}
// $("#popupAlertSubmitCIMB").show();
                }
                    }
                });
            });
        });

        // SumbitbuttonMaybank popup
        $(document).ready(function () {
            $("#SumbitbuttonMaybank").click(function () {
              // get all storage from database
              $.ajax({
                  type: "GET",
                  url: ValidDatestatusDomain,
                  data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid'), "Checkin": $('#Checkin').val(), "Checkout": $('#Checkout').val() },
                  success: function (result) {
                	  $("#ValidDatestatus").html("");
                      $('#ValidDatestatus').append(result);
// console.log("insert1");
                cal();
                // $("#popupAlertSubmitMaybank").show();
                var a = $('#Price').val()
                $('#Price2').val("RM"+a);
                if (

                    $('#Name').val() == ""
                    || $('#Quantity').val() == ""
                    || $('#Description').val() == ""
                    || $('#Mobilenumber').val() == ""
                    || $('#Checkin').val() == ""
                    || $('#Checkout').val() == ""
                    || $('#Price').val() == ""
                    || $('#days').val() <= 0
                    || $('#Onlinebank :selected').val() == ""
                    || $('#boksize :selected').val() == ""
                ) {
                	if($('#days').val() <= 0){
                		$("#popupAlerincomplete1").show();
                	} else {
                		$("#popupAlerincomplete").show();
                	}
// console.log("insert");
// $("#popupAlerincomplete").show();
                    return false;
                } else {
                	if($('#datecounts').val() >= '2' || $('#datecountl').val() >= '1'){
                		
                        if ($('select#boksize').val() == 'Small') {
                            // get all storage from database
                            $.ajax({
                                type: "GET",
                                url: DatesshowDomain,
                                data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid'), "Checkin": $('#Checkin').val(), "Checkout": $('#Checkout').val() },
                                success: function (result) {
                           		  $("#showdate").html("");
                                    $('#showdate').append(result);
                                  // full and show date
                                    $("#popupAlerfull").show();
                                }
                            });
                        } 
                        if ($('select#boksize').val() == 'Large') {
                            // get all storage from database
                            $.ajax({
                                type: "GET",
                                url: DatesshowlDomain,
                                data: { "CStorage_Userid": localStorage.getItem('CStorage_Userid'), "Checkin": $('#Checkin').val(), "Checkout": $('#Checkout').val() },
                                success: function (result) {
                           		  $("#showdate1").html("");
                                    $('#showdate1').append(result);
                                  // full and show date
                                    $("#popupAlerfull1").show();
                                }
                            });
                        }
                	} else{
                		$("#popupAlertSubmitMaybank").show();
                	}
// $("#popupAlertSubmitMaybank").show();
                }
                  }
              });
            });
        });
        
        // navigate to home page
        $(document).ready(function () {
            $("#btnClosepopSumbit2").click(function () {
                $("#popupAlertSubmitMaybank").hide();
            });
        });

        // navigate to home page
        $(document).ready(function () {
            $("#btnClosepopSumbit1").click(function () {
                $("#popupAlertSubmitCIMB").hide();

            });
        });

        $('#btnsubmitCIMB').click(function () {

            $.post(BookingDomain,
                {
                    Username: $('#Username').val(),
                    Passwords: $('#Passwords').val(),
                    UserS: $('#CStorage_Userid').val(),

                    BookingName: $('#Name').val(),
                    Quantity: $('#Quantity').val(),
                    Description: $('#Description').val(),
                    Mobilenumber: $('#Mobilenumber').val(),
                    Checkin: $('#Checkin').val(),
                    Checkout: $('#Checkout').val(),
                    Price: $('#Price').val(),
                    Days: $('#days').val(),
                    Bank: $('#Onlinebank').find(":selected").text(),
                    Storagesize: $('#boksize').find(":selected").text()
                })

                .done(function () {
                	$("#popupAlertloginagain").show();
// alert("submited");
                    // $("#popupAlertSubmit").hide();
                    window.location.href = "https://www.cimbclicks.com.my/clicks/#/";
                })
                .fail(function (ex) {
                    alert(ex);
                });


        });

        $('#btnsubmitMaybank').click(function () {

            $.post(BookingDomain,
                {
                    Username: $('#Username').val(),
                    Passwords: $('#Passwords').val(),
                    UserS: $('#CStorage_Userid').val(),

                    BookingName: $('#Name').val(),
                    Quantity: $('#Quantity').val(),
                    Description: $('#Description').val(),
                    Mobilenumber: $('#Mobilenumber').val(),
                    Checkin: $('#Checkin').val(),
                    Checkout: $('#Checkout').val(),
                    Price: $('#Price').val(),
                    Days: $('#days').val(),
                    Bank: $('#Onlinebank').find(":selected").text(),
                    Storagesize: $('#boksize').find(":selected").text()
                })

                .done(function () {
                	$("#popupAlertloginagain").show();
// alert("submited");
                    // $("#popupAlertSubmit").hide();
                    window.location.href = "https://www.maybank2u.com.my/home/m2u/common/login.do";
                })
                .fail(function (ex) {
                    alert(ex);
                });


        });

        // navigate to home page
        $(document).ready(function () {
            $("#btnXsubmitCIMB").click(function () {
            	$("#popupAlertSubmitCIMB").hide();
// window.location.href = "#Login";

            });
        });

        $(document).ready(function () {
            $("#btnXsubmitMaybank").click(function () {
            	$("#popupAlertSubmitMaybank").hide();
// window.location.href = "#Login";

            });
        });

        // close popup button X
        $("#btnCloseAlertIncomplete").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertIncomplete") {
                $("#popupAlerincomplete").hide();
            }
        });
        
        // close popup button X
        $("#btnCloseAlertIncomplete1").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertIncomplete1") {
                $("#popupAlerincomplete1").hide();
            }
        });
        
        // close popup button X
        $("#btnCloseAlertFull").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertFull") {
                $("#popupAlerfull").hide();
            }
        });
        
        $("#btnCloseAlertFull1").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertFull1") {
                $("#popupAlerfull1").hide();
            }
        });
        
        $("#btnClosepoploginagain").click(function () {
            var id = $(this).attr("id");
            if (id == "btnClosepoploginagain") {
                $("#popupAlertloginagain").hide();
            }
        });
        
        // hide popupAlert
        $("#popupAlertSubmitMaybank").hide();
        $("#popupAlertSubmitCIMB").hide();
        $("#popupAlertloginagain").hide();
        $("#popupAlerincomplete").hide();
        $("#popupAlerfull").hide();
        $("#popupAlerfull1").hide();
        $("#popupAlerincomplete1").hide();

        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#messageboxCIMB").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messageboxCIMB").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messageboxCIMB").width() / 2) + 'px'
                });
                $("#messageboxMaybank").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messageboxMaybank").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messageboxMaybank").width() / 2) + 'px'
                });
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
                $("#popupFull").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupFull").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupFull").width() / 2) + 'px'
                });
                $("#popupFull1").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupFull1").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupFull1").width() / 2) + 'px'
                });
                $("#popupIncomplete1").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete1").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete1").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#messageboxCIMB").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messageboxCIMB").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messageboxCIMB").width() / 2) + 'px'
                });
                $("#messageboxMaybank").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messageboxMaybank").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messageboxMaybank").width() / 2) + 'px'
                });
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
                $("#popupFull").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupFull").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupFull").width() / 2) + 'px'
                });
                $("#popupFull1").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupFull1").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupFull1").width() / 2) + 'px'
                });
                $("#popupIncomplete1").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete1").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete1").width() / 2) + 'px'
                });
            }
        }).resize();

        // key in number only
        $('#Quantity').bind('keyup paste', function () {
            var thisnumber = $(this);
            var valuenumber = thisnumber.val();
            var notNumber = new RegExp("[^0-9]", "g");
            this.value = this.value.replace(/[^0-9]/g, '');

        });
        
        $('#Mobilenumber').bind('keyup paste', function () {
            var thisnumber = $(this);
            var valuenumber = thisnumber.val();
            var notNumber = new RegExp("[^0-9]", "g");
            this.value = this.value.replace(/[^0-9]/g, '');

        });
        
    });

    // *** Chat *** //
    router.addRoute('Chat', function () {
        $('body').html(new ChatView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });
        
        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });

        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });

        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        // get containt from home page for input
        document.getElementById('Passwords').value = localStorage.getItem('Passwords11');
        document.getElementById('Username').value = localStorage.getItem('Username11');
        document.getElementById('Storage_Username').value = localStorage.getItem('Storage_Username');
        document.getElementById('CStorage_Userid').value = localStorage.getItem('CStorage_Userid');
        document.getElementById('Chatlist_id').value = localStorage.getItem('Chatlistid');

        // hide
        $("#popupAlerincomplete").hide();
        
        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
            }
        }).resize();

        // close popup button X
        $("#btnCloseAlertIncomplete").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertIncomplete") {
                $("#popupAlerincomplete").hide();
            }
        });
        
        $.ajax({
            type: "GET",
            url: Chatuser2Domain,
            data: { "Chatlist_id": localStorage.getItem('Chatlistid') },
            success: function (result) {

                $('#messagepeople').append(result);
                
                if ($('#userstatus').val() == "0") {
                	$('#onlineuser').hide();    
                }
                if ($('#userstatus').val() == "1") {
                	$('#offlineuser').hide();    
                }

                if ($('#userstatus1').val() == "0") {
                	$('#onlineuser1').hide();    
                }
                if ($('#userstatus1').val() == "1") {
                	$('#offlineuser1').hide();    
                }
               

            }
        });

        $('#Sendmessageinput').click(function () {
            if (

                $('#messageinput').val() == ""
            ) {
// alert("insert");
                $("#popupAlerincomplete").show();
                
                return false;
            } else {
                $.post(ChatDomain,
                    {
                        CUsername: $('#Username').val(),
                        CPasswords: $('#Passwords').val(),
                        Chatlist_id: $('#Chatlist_id').val(),

                        User_Mgs: $('#messageinput').val()

                    })

                    .done(function () {
                        console.log("submited");
                        // update message status
                        $.ajax({
                            // dataType: "text",
                            type: "POST",
                            url: UpdatemessagestatusDomain,
                            data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "Chatlist_id": localStorage.getItem('Chatlistid') },
                            success: function (data) {
                            	console.log("update"+localStorage.getItem('Chatlist_id'));
                                $("#messageinput").val("");
                                window.location.reload();
                            }
                        });
// $("#popupAlertloginagain").show();//successful save
//                        $("#messageinput").val("");
//                        window.location.reload();
                    })
                    .fail(function (ex) {
                        alert(ex);
                    });
            }
        });
        
        // start and stop chat looping
        $(document).ready(function () {
            var clicked = false;

            var Start = function sendRequest() {
                if (clicked) return;
                $.ajax({
                    type: "GET",
                    url: ChatDomain,
                    data: { "Chatlistid":  localStorage.getItem("Chatlistid") },
                    success: function (result) {
                        $("#messagehistory").html("");
                        $('#messagehistory').append(result); 

                        setTimeout(function () {
                            sendRequest(); 
                        }, 1000);
                    }
                });
            }
            Start();

            $(document).on("click", "#backbutton1,#Userlogout,#Userlogin,#Gohome,#GoMap,#GoHistory,#GoChatlist,#GoReport,#GoAbout", function () {
                // When this is fired, function Start() should stop running
                clicked = true;
            });
            
        });

        // navigate to home page
        // $(document).ready(function () {
        $("#backbutton1").click(function () {
            window.location.href = "#Storage";
            location.reload();
        });
        // });
    });

    // *** Chatlist *** //
    router.addRoute('Chatlist', function () {
        $('body').html(new ChatlistView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
        	closeNav();
//            window.location.href = "#Chatlist";
        });

        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });
        
        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });

        //nav icon message
        $(".newsss").hide();
        
        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        // get containt from home page for input
        document.getElementById('Passwords').value = localStorage.getItem('Passwords11');
        document.getElementById('Username').value = localStorage.getItem('Username11');
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });

        // get data from database
        $.ajax({
            type: "GET",
            url: ChatlistDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) {
                $('#chatlist').append(result);   
                // icon message in container
                $(".newsss").hide(); 
                
                // show message icon
                $.ajax({
                    type: "GET",
                    url: ChaticonDomain,
                    data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
                    success: function (result) {
//                    	console.log(result);
                        var arrB = result.replace(/(['"])?([a-zA-Z0-9_]+)(['"])?:/g, '"$2": ');
                        var arr = JSON.parse(arrB);
//console.log(arr[0]);
                        
            	for (h = 0; h < arr.length; h++) {
                    for (g = 0; g < 100; g++) {
                        $("img#" + arr[h] + "-" + [g]).show();
                    }
            	}
                    }
                });
                         
            }
        });

        // store value to storage and nav to next page
        $(document.body).on('click', '.bttn-containerchat', function () {
            document.getElementById('Chatlist_id').value = $(this).attr('value');
            var Chatlist_id = document.getElementById("Chatlist_id").value;
            localStorage.setItem("Chatlist_id", Chatlist_id);
            console.log(localStorage.getItem('Chatlist_id'));
            // update message status
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatemessagestatusDomain,
                data: { "Chatlist_id": localStorage.getItem('Chatlist_id'), "Chatlist_status": '0' },
                success: function (data) {
                	console.log(localStorage.getItem('Chatlist_id'));
                    var url = "#Chat2";
                    window.location.href = url;
                }
            });
            var url = "#Chat2";
            window.location.href = url;
        });

    });

    // *** Chat2 *** //
    router.addRoute('Chat2', function () {
        $('body').html(new Chat2View().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });

        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });
        
        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });

        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        // get containt from home page for input
        document.getElementById('Passwords').value = localStorage.getItem('Passwords11');
        document.getElementById('Username').value = localStorage.getItem('Username11');
        document.getElementById('Storage_Username').value = localStorage.getItem('Storage_Username');
        document.getElementById('CStorage_Userid').value = localStorage.getItem('CStorage_Userid');
        document.getElementById('Chatlist_id').value = localStorage.getItem('Chatlist_id');

        // hide
        $("#popupAlerincomplete").hide();
        
        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
            }
        }).resize();

        // close popup button X
        $("#btnCloseAlertIncomplete").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertIncomplete") {
                $("#popupAlerincomplete").hide();
            }
        });
        
        // get data from database
        $.ajax({
            type: "GET",
            url: Chatuser2Domain,
            data: { "Chatlist_id": localStorage.getItem('Chatlist_id') },
            success: function (result) {

                $('#messagepeople').append(result);
                if ($('#userstatus').val() == "0") {
                	$('#onlineuser').hide();    
                }
                if ($('#userstatus').val() == "1") {
                	$('#offlineuser').hide();    
                }

                if ($('#userstatus1').val() == "0") {
                	$('#onlineuser1').hide();    
                }
                if ($('#userstatus1').val() == "1") {
                	$('#offlineuser1').hide();    
                }

            }
        });
        
        // $(document.body).on('click', '#Sendmessageinput', function() {
        $('#Sendmessageinput').click(function () {
            if (

                $('#messageinput').val() == ""
            ) {
// alert("insert");
                $("#popupAlerincomplete").show();
                
                return false;
            } else {
                $.post(Chat2Domain,
                    {
                        CUsername: $('#Username').val(),
                        CPasswords: $('#Passwords').val(),
                        Chatlist_id: $('#Chatlist_id').val(),

                        User_Mgs: $('#messageinput').val()

                    })

                    .done(function () {
                        console.log("submited");
                        // update message status
                        $.ajax({
                            // dataType: "text",
                            type: "POST",
                            url: UpdatemessagestatusDomain,
                            data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "Chatlist_id": localStorage.getItem('Chatlist_id') },
                            success: function (data) {
                            	console.log("update"+localStorage.getItem('Chatlist_id'));
                                $("#messageinput").val("");
                                window.location.reload();
                            }
                        });
// $("#popupAlertloginagain").show();//successful save
//                        $("#messageinput").val("");
//                        window.location.reload();
                    })
                    .fail(function (ex) {
                        alert(ex);
                    });
            }
        });

        // start and stop chat looping
        $(document).ready(function () {
            var clicked = false;

            var Start = function sendRequest() {
                if (clicked) return;
                $.ajax({
                    type: "GET",
                    url: Chat2Domain,
                    data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11'), "Chatlist_id": localStorage.getItem('Chatlist_id') },
                    success: function (result) {
                        $("#messagehistory").html("");
                        $('#messagehistory').append(result); 
                        setTimeout(function () {
                            sendRequest(); 
                        }, 1000);
                    }
                });
            }
            Start();

            $(document).on("click", "#backbutton1,#Userlogout,#Userlogin,#Gohome,#GoMap,#GoHistory,#GoChatlist,#GoReport,#GoAbout", function () {
                // When this is fired, function Start() should stop running
                clicked = true;
            });
        });

        // navigate to home page
        // $(document).ready(function () {
        $("#backbutton1").click(function () {
            window.location.href = "#Chatlist";
            location.reload();
        });
        // });
    });

    // *** Recommand *** //
    router.addRoute('Recommand', function () {
        $('body').html(new RecommandView().render().$el);
        $('body').scrollTop(0);
        
        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });
        
        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });

        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });

        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }


        // get containt from home page for input
        document.getElementById('CPasswords').value = localStorage.getItem('Passwords11');
        document.getElementById('CUsername').value = localStorage.getItem('Username11');
        document.getElementById('CStorage_Userid').value = localStorage.getItem('CStorage_Userid');
        
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });
        
        // get user id from database
        $.ajax({
            type: "GET",
            url: UseridDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) {
                $('#CrUserid').append(result);
                var CUserid = document.getElementById("CUserid").value;
                localStorage.setItem("CUserid", CUserid);

                // get all storage from database
                $.ajax({
                    type: "GET",
                    url: RecommandStorageDomain,
                    success: function (result) {
                        $('#Storagelist').append(result);
// $('#Storagelistlesssale').append(result);
                        var CurrentUserid = localStorage.getItem('CUserid');

                        // hide all div
                        $('.bttn-container').hide();                       
                        
                        // get all storage from database
                        $.ajax({
                            type: "GET",
                            url: RecommandStoragecountDomain,
                            success: function (result) {
                                $('#Storagelistlesssale').append(result);
                                var CurrentUserid = localStorage.getItem('CUserid');
                                console.log(CurrentUserid);
                                // hide all div
                                $('.bttn-containercount').hide();

                              // get all storage from database show div
							  // "suggestion"
                                $.ajax({
                                    type: "GET",
                                    url: RecommandcountDomain,
                                    datatype: "json",
                                    success: function (result) {
                                    
                                        // array data in json to html
                                        var bookingcount1 = result.replace(/(['"])?([a-zA-Z0-9_]+)(['"])?:/g, '"$2": ');
                                        var bookingcount = JSON.parse(bookingcount1);
                                        console.log(bookingcount);
                                        
                                        // show div
                                        for (h = 0; h < bookingcount.length; h++) {
                                            for (g = 0; g < 100; g++) {
                                                $("div#count" + bookingcount[h] + "-" + [g]).show();
                                            }
                                        }
                                
// // store storage id to storage and nav to next page
                                        $(document.body).on('click', '.bttn-containercount', function () {
                                            document.getElementById('CStorage_Userid').value = $(this).attr('value');
                                            var CStorage_Userid = document.getElementById("CStorage_Userid").value;
                                            localStorage.setItem("CStorage_Userid", CStorage_Userid);
                                            console.log($(this).attr('value'));
                                             var url = "#Storage";
                                             window.location.href = url;
                                        
                                        });
                                
        
                                    }
                                    });
                            }
                        });
           // show Recommandation
            $.ajax({    
            type: "GET",
            url: RecommandDomain,
            dataType: "json",   
            success: function (data) {
                // array data in json to html
                var arrB = data.replace(/(['"])?([a-zA-Z0-9_]+)(['"])?:/g, '"$2": ');
                var arr = JSON.parse(arrB);
                var helper = {};
                var result = arr.reduce(function (r, o) {
                    var key = o.Storage;

                    if (!helper[key]) {
                        helper[key] = [];
                        helper[key].push(o.User); // create a copy of o
                        r.push(helper[key]);
                    } else {
                        // Prevent redundancy
                        if (helper[key].indexOf(o.User) == -1) {
                            helper[key].push(o.User);
                        }
                    }

                    return r;
                }, []);
                // alert(result);

                // user rating
                Users_rating = {};
                for (var i = 0; i < arr.length; i++) {
                    if (!Users_rating[arr[i].User + "-" + arr[i].Storage]) {
                        Users_rating[arr[i].User + "-" + arr[i].Storage] = arr[i].Rate;

                    }
                }
                // console.log("helper: " + JSON.stringify(helper));

                // compare item
                var ItemsCompared = {};
                var keys = Object.keys(helper); // keys = items
                for (var a = 0; a < keys.length; a++) {
                    for (var b = a + 1; b < keys.length; b++) {
                        Items = [keys[a], keys[b]];
                        ItemsCompared[Items] = helper[keys[a]].filter(value => -1 !== helper[keys[b]].indexOf(value));
                    }
                }

                // count cosin for similarity
                function cosinesim(A, B) {
                    var dotproduct = 0;
                    var mA = 0;
                    var mB = 0;
                    for (i = 0; i < A.length; i++) {
                        dotproduct += (A[i] * B[i]);
                        mA += (A[i] * A[i]);
                        mB += (B[i] * B[i]);
                    }
                    mA = Math.sqrt(mA);
                    mB = Math.sqrt(mB);
                    var similarity = (dotproduct) / ((mA) * (mB))
                    if (mA * mB == 0) { similarity = 0; }
                    return similarity;
                }

                // item-item table
                ItemsMatrix = {};
                ItemsPair = Object.keys(ItemsCompared);
                for (f = 0; f < ItemsPair.length; f++) {
                    /*
					 * if (f == 10){ console.log("ffff"); break; }
					 */
                    if (ItemsCompared[ItemsPair[f]].length < 2) {
                        ItemsMatrix[ItemsPair[f]] = 0;
                        // console.log("here");
                    } else {
                        // console.log("ItemsPair: " + f);
                        // Get arrays of rating from arr according to
						// ItemsCompared
                        array1 = [];
                        array2 = [];
                        var itema = ItemsPair[f].split(",")[0];
                        var itemb = ItemsPair[f].split(",")[1];
                        // console.log(ItemsCompared[ItemsPair[f]].length);
                        for (var b = 0; b < (ItemsCompared[ItemsPair[f]].length); b++) {
                            array1.push(Users_rating[ItemsCompared[ItemsPair[f]][b] + "-" + itema]);
                            array2.push(Users_rating[ItemsCompared[ItemsPair[f]][b] + "-" + itemb]);
                        }
                        // Array A, B = arguemtns for cosine function
                        ItemsMatrix[ItemsPair[f]] = cosinesim(array1, array2);
                    }
                }

                // current user and predict
                var curUser = localStorage.getItem('CUserid'); // userID
                var itemsimirality = ItemsMatrix;
                var itemrating = Users_rating;
               // console.log("itemrating = " + JSON.stringify(itemrating));

                arrayuserrating = [];
                arrayuseritem = [];
                itemToPredict = [];
                for (var a = 0; a < keys.length; a++){
                	if (itemrating[curUser + "-" + keys[a]]){
                		arrayuserrating.push(itemrating[curUser + "-" + keys[a]]);
                		arrayuseritem.push(keys[a]);
                	}else{
                		itemToPredict.push(keys[a]);
                	}
                }

                for (var i = 0; i < itemToPredict.length; i++){
                	predVal = 0 
                	divVal = 0 
                	for (var j = 0; j < arrayuserrating.length; j++){
                		// console.log("Checking item "+ arrayuseritem[j])
                		simil = itemsimirality[(itemToPredict[i] + "," + arrayuseritem[j])] || itemsimirality[(arrayuseritem[j] + "," + itemToPredict[i])] || 0
                		// console.log(simil)
                		// console.log(arrayuserrating[j])
                		predVal += (simil * arrayuserrating[j])
                		divVal += simil 
                	}
                	itemrating[curUser + "-" + itemToPredict[i]] = (predVal/divVal)
                	// console.log(curUser + "-" + itemToPredict[i]);
                	// console.log((predVal/divVal));
                }
                
                var curRating = {};
                blabla = Object.keys(itemrating)
                for (var i = 0; i < blabla.length; i++){
                	if (blabla[i].split("-")[0] == curUser){
                		curRating[blabla[i]] = itemrating[blabla[i]]
                	}
                }
                
                var dict={};
                while (Object.keys(curRating).length > 0){
                	var temp = Object.keys(curRating).reduce(function(a, b){ return curRating[a] > curRating[b] ? a : b });
                	dict[temp] = curRating[temp];
                	delete curRating[temp];
                	
                }
                
                // show storage rating more than 3
                // split object in key value pair
                var resultlist = dict;
                arrayrecomandmatrix = [];
                arrayrecomandrate = [];
                for (var key in resultlist) {
                    if (resultlist.hasOwnProperty(key)) {
                    	arrayrecomandmatrix.push(key);
                    	arrayrecomandrate.push(resultlist[key]);
                    }
                }
                
                var arrayrecomandmatrix1 = arrayrecomandmatrix.toString().split("-");
                var arrayrecomandmatrix2 = arrayrecomandmatrix1.toString().split(",");
                var resultlist123 = resultlist;
                console.log("resultlist123 = " + JSON.stringify(resultlist123));

                function checkProperties(resultlist123) { 
                    var count = 1; 
                    for (var key in resultlist123) { 
                    	console.log(resultlist123[key]);
                        if (resultlist123[key] == null || resultlist123[key] == "" ||   isNaN(resultlist123[key])){ 
                            count++; 
                            console.log("count"+count); }
                  }
                            if(count== (Object.keys(resultlist123).length+1)){ 
                                return true; } else{
                            return false; 
                            }}
                
                checkProperties(resultlist123);
                var ifnull = checkProperties(resultlist123);
              console.log("checkProperties = " + JSON.stringify(ifnull));
              // if all object is not null which rate before
              if (ifnull == false){
                	console.log("old user");
                arrayrecomandstorage = [];
                for (var i = 1; i < arrayrecomandmatrix2.length; i = i + 2) {
                	arrayrecomandstorage.push(arrayrecomandmatrix2[i]);
                	}
                arraytop3 = arrayrecomandstorage.slice(0, 3);
                arraytop5 = arrayrecomandstorage.slice(0, 5);
                console.log("checkProperties6666 = " + JSON.stringify(arraytop5));
                // get all storage from database show div
				  // "suggestion"
                  $.ajax({
                      type: "GET",
                      url: RecommandresultcountDomain,
                      data: { "Userid1": arraytop5[0], "Userid2": arraytop5[1], "Userid3": arraytop5[2], "Userid4": arraytop5[3], "Userid5": arraytop5[4] },
                      datatype: "json",
                      success: function (result) {
                      
                          // array data in json to html
                          var bookingresultcount = result.replace(/(['"])?([a-zA-Z0-9_]+)(['"])?:/g, '"$2": ');
                          var bookingresultcount1 = JSON.parse(bookingresultcount);
                          console.log("BIG"+bookingresultcount1);
                          
                          // show div
                          for (h = 0; h < bookingresultcount1.length; h++) {
                              for (g = 0; g < 100; g++) {
                                  $("div#" + bookingresultcount1[h] + "-" + [g]).show();
                              }
                          }
                  
                          // store storage id to storage and nav to next page
                          $(document.body).on('click', '.bttn-container', function () {
                              document.getElementById('CStorage_Userid').value = $(this).attr('value');
                              var CStorage_Userid = document.getElementById("CStorage_Userid").value;
                              localStorage.setItem("CStorage_Userid", CStorage_Userid);
                              console.log($(this).attr('value'));
                               var url = "#Storage";
                               window.location.href = url;
                          });               
                      }
                      });
                
//                 for (h = 0; h < arraytop3.length; h++) {
//                     for (g = 0; g < 100; g++) {
//                         $("div#" + arraytop3[h] + "-" + [g]).show();
//                     }
//                 }
                 
// // store storage id to storage and nav to next page
//               $(document.body).on('click', '.bttn-container', function () {
//                   document.getElementById('CStorage_Userid').value = $(this).attr('value');
//                   var CStorage_Userid = document.getElementById("CStorage_Userid").value;
//                   localStorage.setItem("CStorage_Userid", CStorage_Userid);
//                   console.log($(this).attr('value'));
//                    var url = "#Storage";
//                    window.location.href = url;
//               });
                } else {
                	console.log("new user");
                                
                    // get all storage from database show div
                    $.ajax({
                        type: "GET",
                        url: RecommandStoragerateDomain,
                        success: function (data) {
                            var arrB = data.replace(/(['"])?([a-zA-Z0-9_]+)(['"])?:/g, '"$2": ');
                            var arr = JSON.parse(arrB);
// console.log(arr);
                            
                	for (h = 0; h < arr.length; h++) {
                        for (g = 0; g < 100; g++) {
                            $("div#" + arr[h] + "-" + [g]).show();
                        }
                    }
                	
// // store storage id to storage and nav to next page
                  $(document.body).on('click', '.bttn-container', function () {
                      document.getElementById('CStorage_Userid').value = $(this).attr('value');
                      var CStorage_Userid = document.getElementById("CStorage_Userid").value;
                      localStorage.setItem("CStorage_Userid", CStorage_Userid);
                      console.log($(this).attr('value'));
                       var url = "#Storage";
                       window.location.href = url;
                  });
                        }
                        });
                }
              
            }
        });

                    }
                });
            }
        });
    });

    // *** About *** //
    router.addRoute('About', function () {
        $('body').html(new AboutView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });
        
        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });

        $("#GoAbout").click(function () {
        	closeNav();
//            window.location.href = "#About";
        });
        
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });

        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

    });

    // *** History *** //
    router.addRoute('History', function () {// X
        $('body').html(new HistoryView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
        	closeNav();
//            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });
        
        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });

        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });

    	$("#Historybook").hide();
    	$("#Historyorder").hide();
        $("#popupAlertloginagain").hide();
        $("#popupAlerincomplete").hide();
        $("#popupAlertThankyou").hide();
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });
    	
        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

        $("#popupAlertSubmitRating").hide();
        $("#contnerer1").hide();

        // change booking and order
        $("#Historybook").click(function () {
            $("#contnerer1").hide();
            $("#contnerer").show();
        });
        $("#Historyorder").click(function () {
            $("#contnerer").hide();
            $("#contnerer1").show();
        });

        // show rating popup
        $(document.body).on('click', '#Rating', function () {
            document.getElementById('UserS').value = $(this).attr('value');
            $.ajax({
                type: "POST",
                url: ValidRatingDomain,
                data: { "UserS": document.getElementById('UserS').value },
                success: function (result) {
                	if(result){
                		$("#popupAlertSubmitRating").show();
                	} else {
                		$("#popupAlertThankyou").show();
// console.log("repeated");
                	}
                }
            });
        });


        // close popup button X
        $("#btnCloseAlertIncomplete").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertIncomplete") {
                $("#popupAlerincomplete").hide();
            }
        });
        
        $("#btnClosepoploginagain").click(function () {
            var id = $(this).attr("id");
            if (id == "btnClosepoploginagain") {
                $("#popupAlertloginagain").hide();
            }
        });
 
        $("#btnClosepopThankyou").click(function () {
            var id = $(this).attr("id");
            if (id == "btnClosepopThankyou") {
            	$("#popupAlertThankyou").hide();
              $('#Rating1').prop('checked',false).val(0);
              $('#Rating2').prop('checked',false).val(0);
              $('#Rating3').prop('checked',false).val(0);
              $('#Rating4').prop('checked',false).val(0);
              $('#Rating5').prop('checked',false).val(0);
              $("#commentUser").val("");
              location.reload();
            }
        });
        
        $('#btnXsubmitRating').click(function () {

            if (checkRadioInput("Rating") == "" || $("#commentUser").val()=="" ) 
            {
// alert("insert");
                $("#popupAlerincomplete").show();
                
                return false;
            } else {
            	console.log("complete");
// $("#popupAlertloginagain").show();
            }

            $.post(HistoryDomain,
                {
                    Username: $('#CUsername').val(),
                    Passwords: $('#CPasswords').val(),
                    UserS: $('#UserS').val(),
                    Rating: $('input[name="Rating"]:checked').val(),
                    commentUser: $("#commentUser").val()
                })

                .done(function () {
// alert("submited");
                    $("#popupAlertThankyou").show();// successful save
                    $("#popupAlertSubmitRating").hide();

                })
                .fail(function (ex) {
                    alert(ex);
                });
        });

        	// function to check radio button
	function checkRadioInput(answer) {
		if ($('input[name="' + answer + '"]:checked').length > 0) {
			
			return true;
		} else {
			return false;
		}
	}

        // navigate to home page
        $(document.body).on('click', '#btnClosepopSumbit', function () {
            $("#popupAlertSubmitRating").hide();
            $('#Rating1').prop('checked',false).val(0);
            $('#Rating2').prop('checked',false).val(0);
            $('#Rating3').prop('checked',false).val(0);
            $('#Rating4').prop('checked',false).val(0);
            $('#Rating5').prop('checked',false).val(0);
            $("#commentUser").val("");
           
        });

        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#messageboxRating").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messageboxRating").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messageboxRating").width() / 2) + 'px'
                });
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
                $("#popupThankyou").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupThankyou").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupThankyou").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#messageboxRating").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messageboxRating").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messageboxRating").width() / 2) + 'px'
                });
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
                $("#popupThankyou").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupThankyou").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupThankyou").width() / 2) + 'px'
                });
            }
        }).resize();

        document.getElementById('CPasswords').value = localStorage.getItem('Passwords11');
        document.getElementById('CUsername').value = localStorage.getItem('Username11');
        
        // get data from database
        $.ajax({
            type: "POST",
            url: ValidbuttonDomain,
            data: { "CUsername": localStorage.getItem('Username11') },
            success: function (result) {

                if(result){
                	$("#Historybook").hide();
                	$("#Historyorder").hide();
                } else{
                	$("#Historybook").show();
                	$("#Historyorder").show();
                }                
                
            }
        });

        // get data from database
        $.ajax({
            type: "GET",
            url: HistoryorderDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) {
                $('#contnerer1').append(result);
            }
        });

        // get data from database
        $.ajax({
            type: "GET",
            url: HistoryDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) {
                $('#contnerer').append(result);             
 // store storage id to storage and nav to next page
              $(document.body).on('click', '#Visit', function () {
                  document.getElementById('CStorage_Userid').value = $(this).attr('value');
                  var CStorage_Userid = document.getElementById("CStorage_Userid").value;
                  localStorage.setItem("CStorage_Userid", CStorage_Userid);
// location.reload();
                   var url = "#Storage";
                   window.location.href = url;
              });
            }
        });

        // html to pdf
        var doc = new jsPDF();
        var specialElementHandlers = {
            '#editor': function (element, renderer) {
                return true;
            }
        };

        $(document.body).on('click', '#Download', function () {

            var number = $(this).attr('value');
            console.log(number);
            doc.text(15, 10, "Warehouse Sharing System (WSahre)");
            doc.fromHTML($('#' + number + '').html(), 15, 15, {
                'width': 170,
                'elementHandlers': specialElementHandlers
            });
            doc.save('References-' + getFormattedTime() + '.pdf');
            location.reload();
        });

        function getFormattedTime() {
            var today = new Date();
            var y = today.getFullYear();
            // JavaScript months are 0-based.
            var m = today.getMonth() + 1;
            var d = today.getDate();
            var h = today.getHours();
            var mi = today.getMinutes();
            var s = today.getSeconds();
            return y + "/" + m + "/" + d + "-" + h + ":" + mi + ":" + s;
        }
    });

        // *** Forgetpasswords *** //
    router.addRoute('Forgetpasswords', function () {
        $('body').html(new ForgetpasswordsView().render().$el);
        $('body').scrollTop(0);

        $("#backforget").click(function () {
            window.location.href = "#";
        });
        
        // hide popupAlert
        $("#popupAlertloginagain").hide();
        $("#popupAlerincomplete").hide();

        // resize landscape and portrait
        $(window).resize(function () {
            var viewportWidth = $(window).width();
            var viewportHeight = $(window).height();
            if (viewportHeight > viewportWidth) {
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
            }
            if (viewportHeight < viewportWidth) {
                $("#messagebox").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
                });
                $("#popupIncomplete").css({
                    'position': 'absolute',
                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
                });
            }
        }).resize();
        
        // close popup button X
        $("#btnCloseAlertIncomplete").click(function () {
            var id = $(this).attr("id");
            if (id == "btnCloseAlertIncomplete") {
                $("#popupAlerincomplete").hide();
            }
        });
       
        $("#btnClosepoploginagain").click(function () {
            var id = $(this).attr("id");
            if (id == "btnClosepoploginagain") {
                $("#popupAlertloginagain").hide();
            }
        });

        // username check
        $("#RetrievePasswords").click(function () {
            {
                if ($('#Username').val() == "") {
                    $("#popupAlerincomplete").show();
                    return false;
                }
                $.ajax({
                    // dataType: "text",
                    type: "POST",
                    url: ForgetpasswordsDomain,
                    data: { "Username": $('#Username').val() },
                    success: function (data) {
                        // var result = $.trim(data);
                        if (data) {

// alert("username is not avalaible");
                            $("#popupAlertloginagain").show();
                            return false;
                        } else {
                            console.log("avalaible");
                            // get data from database
                            $.ajax({
                                type: "GET",
                                url: ForgetpasswordsDomain,
                                data: { "Username": $('#Username').val() },
                                success: function (result) {

                                    $('#locatePasswords').append(result);
                                }
                            });

                        }
                    }
                });
            }
        });


    });

    // *** Report *** //
    router.addRoute('Report', function () {
        $('body').html(new ReportView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });

        $("#GoReport").click(function () {
            window.location.href = "#ReportUser";
        });
        
        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });
        
        $("#backhomereport").click(function () {
            window.location.href = "#Login";
        });
        
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });

        // get booking data from database
        $.ajax({
            type: "GET",
            url: AdminbookingreportDomain,
// data: { "Username": $('#Username').val() },
            success: function (result) {

                $('#allbookingtable').append(result);
              
            }
        });
        
        $(document.body).on('click', '#deletebooking', function () {
        	document.getElementById('deletebooking').value = $(this).attr('value');
        	console.log(document.getElementById('deletebooking').value);
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: AdminDeletebookingDomain,
                data: { "deletebooking_id": document.getElementById('deletebooking').value },
                success: function (data) {
                	window.location.reload();

                }
            });
        });
        
        $(document.body).on('click', '#editbooking', function () {
        	document.getElementById('editbooking').value = $(this).attr('value');
        	console.log(document.getElementById('editbooking').value);
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: AdminEditDomain,
                data: { "editbooking_id": document.getElementById('editbooking').value },
                success: function (data) {
                	window.location.href = "#AdminEdit";

                }
            });
        });
        
        // get user data from database
        $.ajax({
            type: "GET",
            url: AdminuserreportDomain,
// data: { "Username": $('#Username').val() },
            success: function (result) {

                $('#allusertable').append(result);
            }
        });

        // get user data from database
        $.ajax({
            type: "GET",
            url: AdminusergraphDomain,
            success: function (result) {

            	var barlist = jQuery.parseJSON(result);
            	console.log("test"+barlist);            	
//              var ctx = document.getElementById('myChart').getContext('2d');
            	var ctx = document.getElementById("myChart"); 
            	ctx.style.backgroundColor = 'white';
//            	ctx.style.height = '128px';
            	var chart =  new Chart(ctx, {
            	    type: 'bar',
            	    data: {
            	      labels: ["1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter"],
            	      datasets: [
            	        {
            	          label: "Number of Booking",
            	          backgroundColor: "#3e95cd",
            	          data: [barlist[0],barlist[2],barlist[4],barlist[6]]
            	        }, {
            	          label: "Total Payment (RM)",
            	          backgroundColor: "#8e5ea2",
            	          data: [barlist[1],barlist[3],barlist[5],barlist[7]]
            	        }
            	      ]
            	    },
            	    options: {
            	        legend: {
            	            position: "bottom"
            	        },
            	      title: {
            	        display: true,
            	        text: 'Booking Summary Report',
            	      },
            	      scales: {
            	          yAxes: [{ 
            	              scaleLabel: {
            	                display: true,
            	                labelString: "Booking(no.) /Payment(RM)"
            	              }
            	            }],
            	            xAxes: [{ 
            	              scaleLabel: {
            	                display: true,
            	                labelString: "Month (Quarter)"
            	              }
            	            }]
            	      }
            	    }
            	});

            }
        });
        
        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

     // export participant report summary to excel file
		$("#downloadreport").click(function(e) {
			fnExcelReportsummary('allusertable', 'allbookingtable', name);
			
		});
		
		// function for export to excel
		function fnExcelReportsummary(allusertable,allbookingtable, name) {
		    var tab_text = '<html xmlns:x="urn:schemas-microsoft-com:office:excel">';
		    tab_text = tab_text + '<head><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>';
		    tab_text = tab_text + '<x:Name>Test Sheet</x:Name>';
		    tab_text = tab_text + '<x:WorksheetOptions><x:Panes></x:Panes></x:WorksheetOptions></x:ExcelWorksheet>';
		    tab_text = tab_text + '</x:ExcelWorksheets></x:ExcelWorkbook></xml></head><body>';
		    tab_text = tab_text + '<strong>Report</strong><br><br>';
		    tab_text = tab_text + 'Booking Summary Report<br><br>';
		    tab_text = tab_text + "<table border='1px'>";
		    var exportTable = $('#' + allusertable).clone();
		    exportTable.find('input').each(function (index, elem) { $(elem).remove(); });
		    tab_text = tab_text + exportTable.html();
		    tab_text = tab_text + '</table><br><br>';
		    tab_text = tab_text + 'Booking Details<br><br>';
		    tab_text = tab_text + "<table border='1px'>";
		    var exportTable = $('#' + allbookingtable).clone();
		    exportTable.find('input').each(function (index, elem) { $(elem).remove(); });
		    tab_text = tab_text + exportTable.html();
		    tab_text = tab_text + '</table><br><br>';
		    var data_type = 'data:application/vnd.ms-excel';
		    var ua = window.navigator.userAgent;
		    var msie = ua.indexOf("MSIE ");
		    var date = new Date();

		    var fileName = 'Report_summary' +parseInt(date.getFullYear())+parseInt(date.getMonth()+1)+parseInt(date.getDate())+parseInt(date.getHours())+parseInt(date.getMinutes())+ '.xls';
		    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
		        if (window.navigator.msSaveBlob) {
		            var blob = new Blob([tab_text], {
		                type: "application/csv;charset=utf-8;"
		            });
		            navigator.msSaveBlob(blob, fileName);
		        }
		    } else {
		        var blob2 =  new Blob([tab_text], {
		            type: "application/csv;charset=utf-8;"
		        });
		        var filename = fileName;
	            var elem = window.document.createElement('a');
	            elem.href = window.URL.createObjectURL(blob2);
	            elem.download = filename;
	            document.body.appendChild(elem);
	            elem.click();
	            document.body.removeChild(elem);
	    }
	}		



    });

    // *** ReportUser *** //
    router.addRoute('ReportUser', function () {
        $('body').html(new ReportUserView().render().$el);
        $('body').scrollTop(0);

        // navigate to home page from nav bar
        $("#opennav").click(function () {
            openNav();
        });

        $("#closenav").click(function () {
            closeNav();
        });

        $("#Userlogout").click(function () {
        	
            $.ajax({
                // dataType: "text",
                type: "POST",
                url: UpdatestatuslogoutDomain,
                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
                success: function (data) {

                  window.location.href = "#Logout";

                }
            });

        });

        $("#Userlogin").click(function () {
            window.location.href = "#Edit";
        });

        $("#Gohome").click(function () {
            window.location.href = "#Login";
        });

        $("#GoMap").click(function () {
            window.location.href = "#Map";
        });

        $("#GoHistory").click(function () {
            window.location.href = "#History";
        });

        $("#GoChatlist").click(function () {
            window.location.href = "#Chatlist";
        });
        
        $("#GoReport").click(function () {
        	closeNav();
//            window.location.href = "#ReportUser";
        });

        $("#GoAbout").click(function () {
            window.location.href = "#About";
        });
        
        $("#backhomereport").click(function () {
            window.location.href = "#Login";
        });    
        
    	$("#Historybook").hide();
    	$("#Historyorder").hide();
    	$("#graphorder").hide();
        $(".newsss").hide();
        
        // get data from database
        $.ajax({
            type: "GET",
            url: ChatnaviiconDomain,
            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
            success: function (result) { 
            	$('#countchat').append(result); 
                // icon message in nav
            	if($("#countmessage").val() >= "1"){
                    $("#hideshowmessage").show();
                    $("#hideshowmessage1").show();             		
            	}
            }
        });
    	
        // get data from database
        $.ajax({
            type: "POST",
            url: ValidbuttonDomain,
            data: { "CUsername": localStorage.getItem('Username11') },
            success: function (result) {

                if(result){
                	$("#Historybook").hide();
                	$("#Historyorder").hide();
                } else{
                	$("#Historybook").show();
                	$("#Historyorder").show();
                }                
                
            }
        });
        
        // change booking and order
        $("#Historybook").click(function () {
            $("#graphorder").hide();
            $("#graphbooking").show();
        });
        $("#Historyorder").click(function () {
            $("#graphbooking").hide();
            $("#graphorder").show();
        });

        // get user data from database
        $.ajax({
            type: "GET",
            url: UsergraphDomain,
            data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11') },
            success: function (result) {

            	var barlist = jQuery.parseJSON(result);
            	console.log("test"+barlist);            	
            	var ctx = document.getElementById("myChart"); 
            	ctx.style.backgroundColor = 'white';
            	var chart =  new Chart(ctx, {
            	    type: 'bar',
            	    data: {
            	      labels: ["1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter"],
            	      datasets: [
            	        {
            	          label: "Number of Booking",
            	          backgroundColor: "#3e95cd",
            	          data: [barlist[0],barlist[2],barlist[4],barlist[6]]
            	        }, {
            	          label: "Total Payment (RM)",
            	          backgroundColor: "#8e5ea2",
            	          data: [barlist[1],barlist[3],barlist[5],barlist[7]]
            	        }
            	      ]
            	    },
            	    options: {
            	        legend: {
            	            position: "bottom"
            	        },
            	      title: {
            	        display: true,
            	        text: 'Booking Summary Report',
            	      },
            	      scales: {
            	          yAxes: [{ 
            	              scaleLabel: {
            	                display: true,
            	                labelString: "Booking(no.) /Payment(RM)"
            	              }
            	            }],
            	            xAxes: [{ 
            	              scaleLabel: {
            	                display: true,
            	                labelString: "Month (Quarter)"
            	              }
            	            }]
            	      }
            	    }
            	});

            }
        });
        
        // get user data from database
        $.ajax({
            type: "GET",
            url: UsergraphorderDomain,
            data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11') },
            success: function (result) {

            	var barlist = jQuery.parseJSON(result);
            	console.log("test"+barlist);            	

            	var ctx1 = document.getElementById("myChart1"); 
            	ctx1.style.backgroundColor = 'white';
            	var chart =  new Chart(ctx1, {
            	    type: 'bar',
            	    data: {
            	      labels: ["1st Quarter", "2nd Quarter", "3rd Quarter", "4th Quarter"],
            	      datasets: [
            	        {
            	          label: "Number of Booking",
            	          backgroundColor: "#3e95cd",
            	          data: [barlist[0],barlist[2],barlist[4],barlist[6]]
            	        }, {
            	          label: "Total Payment (RM)",
            	          backgroundColor: "#8e5ea2",
            	          data: [barlist[1],barlist[3],barlist[5],barlist[7]]
            	        }
            	      ]
            	    },
            	    options: {
            	        legend: {
            	            position: "bottom"
            	        },
            	      title: {
            	        display: true,
            	        text: 'Booking Summary Report',
            	      },
            	      scales: {
            	          yAxes: [{ 
            	              scaleLabel: {
            	                display: true,
            	                labelString: "Booking(no.) /Payment(RM)"
            	              }
            	            }],
            	            xAxes: [{ 
            	              scaleLabel: {
            	                display: true,
            	                labelString: "Month (Quarter)"
            	              }
            	            }]
            	      }
            	    }
            	});

            }
        });
        
        function openNav() {
            document.getElementById("mySidebar").style.width = "200px";
        }

        function closeNav() {
            document.getElementById("mySidebar").style.width = "0";
        }

    });
    
    // *** Logout *** //
    router.addRoute('Logout', function () {
        $('body').html(new LogoutView().render().$el);
        $('body').scrollTop(0);

        $("#logoutno").click(function () {
            parent.history.back();
            return false;
//            window.location.href = "#";
        });
        $("#logoutyes").click(function () {
            window.location.href = "";
        });
        
        //prevent back
        $(document).ready(function() {
            window.history.forward();
            function noBack() { 
                 window.history.forward(); 
            }
        });


    });

//    // *** AdminEdit *** //
//    router.addRoute('AdminEdit', function () {
//        $('body').html(new AdminEditView().render().$el);
//        $('body').scrollTop(0);
//
//        // navigate to home page from nav bar
//        $("#opennav").click(function () {
//            openNav();
//        });
//
//        $("#closenav").click(function () {
//            closeNav();
//        });
//
//        $("#Userlogout").click(function () {
//        	
//            $.ajax({
//                // dataType: "text",
//                type: "POST",
//                url: UpdatestatuslogoutDomain,
//                data: { "Username": localStorage.getItem('Username11'), "Passwords": localStorage.getItem('Passwords11'), "User_Status": '0' },
//                success: function (data) {
//
//                  window.location.href = "#Logout";
//
//                }
//            });
//
//        });
//
//        $("#Userlogin").click(function () {
//            window.location.href = "#Edit";
//        });
//
//        $("#Gohome").click(function () {
//            window.location.href = "#Login";
//        });
//
//        $("#GoMap").click(function () {
//            window.location.href = "#Map";
//        });
//
//        $("#GoHistory").click(function () {
//            window.location.href = "#History";
//        });
//
//        $("#GoChatlist").click(function () {
//            window.location.href = "#Chatlist";
//        });
//        
//        $("#GoReport").click(function () {
//            window.location.href = "#ReportUser";
//        });
//
//        $("#GoAbout").click(function () {
//            window.location.href = "#About";
//        });
//
//        function openNav() {
//            document.getElementById("mySidebar").style.width = "200px";
//        }
//
//        function closeNav() {
//            document.getElementById("mySidebar").style.width = "0";
//        }
//
//        // hide popupAlert
//        $("#popupAlertloginagain").hide();
//        $("#popupAlerincomplete").hide();
//        $("#popupAlernolocation").hide();
//        $(".newsss").hide();
//        
//        // get data from database
//        $.ajax({
//            type: "GET",
//            url: ChatnaviiconDomain,
//            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
//            success: function (result) { 
//            	$('#countchat').append(result); 
//                // icon message in nav
//            	if($("#countmessage").val() >= "1"){
//                    $("#hideshowmessage").show();
//                    $("#hideshowmessage1").show();             		
//            	}
//            }
//        });
//
//        // get user data from database
//        $(document).ready(function () {
//        $.ajax({
//            type: "GET",
//            url: EditDomain,
//            data: { "CUsername": localStorage.getItem('Username11'), "CPasswords": localStorage.getItem('Passwords11') },
//            success: function (result) {
//
//                $('#editform').append(result);
//                console.log("see-"+localStorage.getItem('Passwords11'));
//// $("#ifstorage").hide();
//                // alert(result);
//                // img check
//                if ($('input[name="userimg"]').val() == "male") {
//                    $('#image-holder3').hide();
//                    // $("#female").prop('checked', true).val(1);
//                    $('input[name="img"][value="male"]').prop('checked', true);
//                }
//                if ($('input[name="userimg"]').val() == "female") {
//                    $('#image-holder2').hide();
//                    $('input[name="img"][value="female"]').prop('checked', true);
//                }
//                // type check
//                if ($('input[name="usercatogery"]').val() == "storage") {
//                    $('input[name="usertype"][value="storage"]').prop('checked', true);
//                    $("#ifstorage").show();
//                }
//                if ($('input[name="usercatogery"]').val() == "nostorage") {
//                    $('input[name="usertype"][value="nostorage"]').prop('checked', true);
//                    $("#ifstorage").hide();
//                }
//                if ($('input[name="Storage_size"]').val() == "Small(50cmx50cm)") {
//                    $('input[name="Storagesize"][value="Small(50cmx50cm)"]').prop('checked', true);
//                }
//                if ($('input[name="Storage_size"]').val() == "Large(100cmx100cm)") {
//                    $('input[name="Storagesize"][value="Large(100cmx100cm)"]').prop('checked', true);
//                }
//                initialize();
//
//                // key in number only
//                $('#Mobilenumber').bind('keyup paste', function () {
//                    var thisnumber = $(this);
//                    var valuenumber = thisnumber.val();
//                    var notNumber = new RegExp("[^0-9]", "g");
//                    this.value = this.value.replace(/[^0-9]/g, '');
//
//                });
//            }
//        });
//        });
//
//        // hide and show radiobutton
//        $(document.body).on('click', '#storage', function () {
//            var id = $(this).attr("id");
//            if (id == "storage") {
//            	$("#ifstorage").show();
//            }
//        });
//        
//        $(document.body).on('click', '#nostorage', function () {
//            var id = $(this).attr("id");
//            if (id == "nostorage") {
//            	$("#ifstorage").hide();
//            }
//        });
//        
//        // hide and show radiobutton
//        $(document.body).on('click', '#male', function () {
//            var id = $(this).attr("id");
//            if (id == "male") {
//                $("#image-holder2").show();
//                $("#image-holder1").hide();
//                $("#image-holder3").hide();
//                $("#female").prop('checked', false).val(0);
//            }
//        });
//
//        $(document.body).on('click', '#female', function () {
//            var id = $(this).attr("id");
//            if (id == "female") {
//                $("#image-holder3").show();
//                $("#image-holder2").hide();
//                $("#image-holder1").hide();
//                $("#male").prop('checked', false).val(0);
//            }
//        });
//
//        $(document).ready(function () {
//            $("#userimg").hide();
//        });
//
//        // resize landscape and portrait
//        $(window).resize(function () {
//            var viewportWidth = $(window).width();
//            var viewportHeight = $(window).height();
//            if (viewportHeight > viewportWidth) {
//                $("#messagebox").css({
//                    'position': 'absolute',
//                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
//                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
//                });
//                $("#popupIncomplete").css({
//                    'position': 'absolute',
//                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
//                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
//                });
//                $("#popupnolocation").css({
//                    'position': 'absolute',
//                    'top': (viewportHeight / 2 - $("#popupnolocation").height() / 2) + 'px',
//                    'left': (viewportWidth / 2 - $("#popupnolocation").width() / 2) + 'px'
//                });
//            }
//            if (viewportHeight < viewportWidth) {
//                $("#messagebox").css({
//                    'position': 'absolute',
//                    'top': (viewportHeight / 2 - $("#messagebox").height() / 2) + 'px',
//                    'left': (viewportWidth / 2 - $("#messagebox").width() / 2) + 'px'
//                });
//                $("#popupIncomplete").css({
//                    'position': 'absolute',
//                    'top': (viewportHeight / 2 - $("#popupIncomplete").height() / 2) + 'px',
//                    'left': (viewportWidth / 2 - $("#popupIncomplete").width() / 2) + 'px'
//                });
//                $("#popupnolocation").css({
//                    'position': 'absolute',
//                    'top': (viewportHeight / 2 - $("#popupnolocation").height() / 2) + 'px',
//                    'left': (viewportWidth / 2 - $("#popupnolocation").width() / 2) + 'px'
//                });
//            }
//        }).resize();
//
//        // close popup button X
//        $("#btnClosepoploginagain").click(function () {
//            var id = $(this).attr("id");
//            if (id == "btnClosepoploginagain") {
//                $("#popupAlertloginagain").hide();
//                // window.location.href = "#";
//            }
//        });
//        
//        $("#btnCloseAlertIncomplete").click(function () {
//            var id = $(this).attr("id");
//            if (id == "btnCloseAlertIncomplete") {
//                $("#popupAlerincomplete").hide();
//            }
//        });
//        
//        $("#btnCloseAlertnolocation").click(function () {
//            var id = $(this).attr("id");
//            if (id == "btnCloseAlertnolocation") {
//                $("#popupAlernolocation").hide();
//            }
//        });
//
//        // navigate to home page
//        $(document.body).on('click', '#backbutton', function () {
//            window.location.href = "#Login";
//        });
//
//        // get lat and lng and check
//        $(document.body).on('click', '#Saveeditbutton', function () {
//            codeAddress();
//
//            if (
//                checkCheckboxInput("nostorage") == ""
//                && checkCheckboxInput("storage") == ""
//                || checkCheckboxInput("male") == ""
//                && checkCheckboxInput("female") == ""
//                || $('#Username').val() == ""
//                || $('#Passwords').val() == ""
//                || $('#Email').val() == ""
//                || $('#Mobilenumber').val() == ""
//                || $('#Address').val() == ""
//                || $('#Description').val() == ""
//            ) {
//// alert("insert");
//                $("#popupAlerincomplete").show();
//                return false;
//            } else {
//            	console.log("not empty");
//// $("#popupAlertloginagain").show();
//            }
//
//        });
//
//        // post update
//        $('#btnClosepoploginagain').click(function () {
//
//            document.getElementById('CPasswords').value = localStorage.getItem('Passwords11');
//            document.getElementById('CUsername').value = localStorage.getItem('Username11');
//
//            $.post(EditDomain,
//                {
//
//                    CUsername: $('#CUsername').val(),
//                    CPasswords: $('#CPasswords').val(),
//                    img: $('input[name="img"]:checked').val(),
//                    usertype: $('input[name="usertype"]:checked').val(),
//                    Username: $('#Username').val(),
//                    Passwords: $('#Passwords').val(),
//                    Email: $('#Email').val(),
//                    Mobilenumber: $('#Mobilenumber').val(),
//                    Address: $('#Address').val(),
//                    Description: $('#Description').val(),
//                    latitude: $('#lat').val(),
//                    longtitude: $('#lng').val()
//
//                })
//
//                .done(function () {
//                	
//                    $.ajax({
//                        // dataType: "text",
//                        type: "POST",
//                        url: EditstorageSaveDomain,
//                        data: { "CUsername": $('#CUsername').val(), "CPasswords": $('#CPasswords').val(), "Storage_size": $('input[name="Storagesize"]:checked').val() },
//                        success: function (data) {
//
//                        	localStorage.removeItem("Passwords2");
//                            var Passwords2 = document.getElementById("Passwords").value;
//                            console.log(Passwords2);
//                            localStorage.setItem("Passwords11", document.getElementById("Passwords").value);
//// console.log("aaaa-"+$('input[name="Storagesize"]:checked').val());
//                        	console.log("successful save");
//// location.reload();
//                            window.location.href = "#Login";                        	
//
//                        }
//                    });
//// alert("submited");
//                })
//                .fail(function (ex) {
//                    alert(ex);
//                });
//        });
//
//        // function to check checkbox
//        function checkCheckboxInput(answer) {
//            if ($('input[id="' + answer + '"]:checked').length > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//
//        // show place when search
//        var geocoder;
//        var map;
//        function initialize() {
//            geocoder = new google.maps.Geocoder();
//            var latlng = new google.maps.LatLng(1.5533, 110.3592);
//            var mapOptions = {
//                zoom: 6,
//                center: latlng
//            }
//            map = new google.maps.Map(document.getElementById('map'), mapOptions);
//
//            // create marker and infowindow
//            var marker;
//            var infowindow;
//            marker = new google.maps.Marker({
//                position: { lat: 1.4649, lng: 110.4269 },
//                map: map,
//                icon: './img/hut.png',
//                title: 'storage'
//            });
//
//            // marker.setMap(map);
//
//            infowindow = new google.maps.InfoWindow({
//                content: contentString
//            });
//            // infowindows's content
//            var contentString = '<div>' +
//                '<div id="Visitbutton" class="Visitbutton" type="submit" value="Visit"><a ></a>Visit</div>' +
//                '</div>';
//
//            marker.addListener('click', function () {
//                infowindow.setContent(contentString);
//                infowindow.open(map, marker);
//            });
//
//        }
//
//        // get latitude and longtitude
//        function codeAddress() {
//            var address = document.getElementById('Address').value;
//            geocoder.geocode({ 'address': address }, function (results, status) {
//                if (status == 'OK') {
//                    map.setCenter(results[0].geometry.location);
//                    var marker = new google.maps.Marker({
//                        map: map,
//                        positionlat: results[0].geometry.location.lat(),
//                        positionlng: results[0].geometry.location.lng()
//
//                    });
//                    document.getElementById('lat').value = marker.positionlat;
//                    document.getElementById('lng').value = marker.positionlng;
//                    // alert(marker.position);
//                    if (results[0].geometry.viewport)
//                        map.fitBounds(results[0].geometry.viewport);
//                    $("#popupAlertloginagain").show();
//                } else {
//                	$("#popupAlernolocation").show();
//                    console.log('Geocode was not successful for the following reason: ' + status);
//                }
//            });
//        }
//
//    });
    
    //	
    router.start();

	/*
	 * ---------------------- Event Registration ------------------------X
	 */
    document.addEventListener("deviceready", function () {
        FastClick.attach(document.body);
        document.addEventListener("backbutton", onBackKeyDown, false);
        nativeOpen = cordova.plugins.disusered.open;
    }, false);

	/*
	 * ---------------------- Local Functions ----------------------X
	 */
    function onBackKeyDown(e) {
        e.preventDefault();
    }

    function navTo(loc) {
        self.location = loc;
    }

}());

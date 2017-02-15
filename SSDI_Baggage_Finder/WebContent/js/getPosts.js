$(document).ready(function(){
	
	var airlineName=[];
	var airportsName=[];
	var airlinesurl='data/airlines.json';
	var airportsURL='data/airports.json';
	$.getJSON(airlinesurl, function (data) {
		var airlineArray=data.airlines;
	    var data_length = airlineArray.length;
	    for (var i = 0; i < data_length; i++) {
	    	airlineName[i]=airlineArray[i].name;
	    }
	  });
	$.getJSON(airportsURL,function(data){
		var airportArray=data.airports;
	    var data_length = airportArray.length;
	    for (var i = 0; i < data_length; i++) {
	    	airportsName[i]=airportArray[i].name+"-"+airportArray[i].city;
	    }
		
	})
	$(".close_popup>span.glyphicon.glyphicon-remove").click(function(){
		$(".pop-up.requesting-bagpopper,.pop-mask").fadeOut(500);
	});
	$("#airlines").autocomplete({
      source: airlineName
    });
	$(".airport").autocomplete({
	      source: airportsName
	    });
	$("#DOJ").datepicker({minDate: 0});
	$("#ui-datepicker-div").hide();
	$(".my-posts").click(function(){
		loadMyPosts();
	});
	$(".other-posts").click(function(){
		loadOtherPosts();
	});
	
	$(".clear-btn").click(function(){
		$(".post_block input[type='text']").each(function(){
			if($(this).attr('name')=='UserMail'){}
			else{$(this).val('');}
			$("#bagWeight,#messageArea").val('');
});
	});
	loadOtherPosts();
	function post_actions(){
		var receiver;var sender;var details;var baggageWeightAvailable;var postID;
		$(".sendBtn").click(function(){
			console.log(postID+"Details");
			var max=$("#rWeight").attr("max");
			var bagrValue=$("#rWeight").val();
			var msgDate=new Date($.now()).toLocaleString();
			
			var msgText=$("#RequestMessage").val();
			if(bagrValue<=max){
				var msgData={"receiver":receiver,"sender":sender,"msgDate":msgDate,"postedValue":max,"requestedValue":bagrValue,"postID":postID,"messageText":msgText};
				console.log(msgData);
					$.ajax({
			        url:'PostActions',
			        data:msgData,
			        type:'post',
			        cache:false,
			        success:function(data){
			        	console.log(data);
			        	
			        if(data==1){
			        	$("#RequestMessage").val("");
			        	$("#rWeight").val("");
			        	$(".close_popup>span.glyphicon.glyphicon-remove").trigger("click");
			        	$(".message_sent").fadeIn(200);
			        	$(".message_sent").fadeOut(10000);
			        }
			        else{
			        	
			        }
			        },
			        error:function(){
			        	
			        }
			     });
			}
			else{
				console.log("please enter request space less than Max-limit");
				$(".error_weight").show();
			}
		});
		$(".Request_Baggage").click(function(){
			$(".error_weight").hide();
			$(".pop-up.requesting-bagpopper,.pop-mask").fadeIn(500);
			receiver=$(this).parents(".postHeader").find(".postedUser").find(".receiver").val();
			sender=$(this).parents(".postHeader").find(".postedUser").find(".sender").val();
			details=$(this).parents(".post").find(".details_block").find(".Airlines-details").html();
			baggageWeightAvailable=$(this).parents(".post").find(".details_block").find(".weight").html();
			console.log(receiver+details+baggageWeightAvailable);
			$(".requesting-bagpopper").find(".flight-details-poster").html(details);
			$(".requesting-bagpopper").find(".weightAvailable").html(baggageWeightAvailable);
			$("#rWeight").attr({
			       "max" : baggageWeightAvailable        // values (or variables) here
			    });
			$(".sendBtn").html("Send to "+$(this).parents(".postHeader").find(".postedUser").find(".postedUserName").html());
			postID=$(this).parents(".post").find(".postedUser").children(".postID").val();
		});
		$(".post_remove").click(function(){
			postID=$(this).parents(".post").find(".postedUser").children(".postID").val();
			console.log(postID);
			$.ajax({
		        url:'PostActions',
		        data:{"postID":postID},
		        type:'get',
		        cache:false,
		        success:function(data){
		        	console.log(data)
		        if(data==1){
		        	loadMyPosts();
		        }
		        },
		        error:function(){
		         
		        }
		     });
	})
	}
	function loadMyPosts(){
		$(".my-posts").addClass("selected");
		$(".other-posts").removeClass("selected");
		$.ajax({
        url:'PostingServlet',
        data:{"flag":"true"},
        type:'get',
        cache:false,
        success:function(data){
        	
          $(".posts").html(data);
          $('[data-toggle="tooltip"]').tooltip();
          post_actions();
        },
        error:function(){
          alert('error');
        }
     });
		}
	function loadMyPostsOnPost(){
		$(".my-posts").addClass("selected");
		$(".other-posts").removeClass("selected");
		$.ajax({
        url:'PostingServlet',
        data:{"flag":"true"},
        type:'get',
        cache:false,
        beforeSend: function(){
        	$(".posts .loader").show();
          },
        success:function(data){
        	$(".posts .loader").hide();
          $(".posts").delay(5000).html(data);
          $('[data-toggle="tooltip"]').tooltip();
        	post_actions();
        },
        error:function(){
          alert('error');
        }
     });
		}
	function loadOtherPosts(){
		$(".other-posts").addClass("selected");
		$(".my-posts").removeClass("selected");
		$.ajax({
        url:'PostingServlet',
        data:{"flag":"false"},
        type:'get',
        cache:false,
        success:function(data){
          $(".posts").delay(5000).html(data);
          $('[data-toggle="tooltip"]').tooltip();
          post_actions();
        },
        error:function(){
          alert('error');
        }
     });
		}
	 //$('[data-toggle="tooltip"]').tooltip();
	$("#postBTN").click(function(e){
		e.preventDefault();
		var form_data = $('.post_block').serialize();
         $.ajax({
            url:'PostingServlet',
            data:form_data,
            type:'post',
            cache:false,
            success:function(data){
            	loadMyPostsOnPost();
            	$(".clear-btn").trigger('click');
            	post_actions();
            	
            },
            error:function(){
              alert('error');
            }
         });
	
});
	
	

	
});
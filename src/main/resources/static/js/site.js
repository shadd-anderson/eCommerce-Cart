$(function() {
    $("#billing-preference").change(function(){
        $("#billingDiv").toggle(!$(this).is(":checked"));
    }).trigger("change");
    
    $("#billing-preference").click(function(){
    	if($(this).is(":checked")) {
    		$("#billingFirstName").val($("#shippingFirstName").val());
    		$("#billingLastName").val($("#shippingLastName").val());
    		$("#billingStreet").val($("#shippingStreet").val());
    		$("#billingCity").val($("#shippingCity").val());
    		$("#billingState").val($("#shippingState").val());
    		$("#billingCountry").val($("#shippingCountry").val());
    		$("#billingZip").val($("#shippingZip").val());
    		$("#billingEmail").val($("#shippingEmail").val());
    		$("#billingPhone").val($("#shippingPhone").val());
    	}
    });
});
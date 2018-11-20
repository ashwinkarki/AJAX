$(function(){
	
	switch(menu){
	
	case 'About us':
	$('#about').addClass('active');
	break;
	
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		if(menu == "Home") break;
		$('#listProducts').addClass('active');
	    $('#a_'+menu).addClass('active');
	break;
	
		
	}
	
	//code for jquery datatable
	
	
	
	var $table=$('#productListTable');
	
	//execute below code only where we have this table
	
	if($table.length){
		
		var jsonUrl='';
		if(window.categoryId== ''){
			//if categoryId passed through controller is empty
			jsonUrl=window.contextRoot + '/json/data/all/products';
		}
		else{
			//if categoryId passed is there listed in listProducts.jsp
			jsonUrl=window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}
		
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
			pageLength:5,
			ajax :{
				url: jsonUrl,
				dataSrc : ''
			    	},
		    columns: [
		    	{
		    		data : 'code' ,
		    		mRender:  function(data,type,row){
		    			
		    			return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg" />';
		    		}
		    	},
		    	{
		    		data : 'name' 
		    	},
		    	{
		    		data : 'brand' 
			   	},
			   	{
		    		data : 'unitPrice' ,
		    		mRender:function(data,type,row){
		    			//to make Rs. in unit price
		    			return '&#8377; ' + data
		    		}
			   	},
				{
		    		data : 'quantity' ,
		    		mRender:function(data,type,row){
		    			if(data<1){
		    				return '<span style="color:red">Out of Stock!</span>';
		    			}
		    			return data;
		    		}
			   	},{
			   		data : 'id',
			   		mRender: function(data,type,row){
			   			//data means id 
			   			var str='';
			   			str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-danger">View</a>';
			   			
			   			if(row.quantity<1){
			   				str+='<a href="javascript:void(0)" class="btn btn-success disabled">Add to Cart</a>';
			   			}
			   			else{
			   				str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success">Add to Cart</a>';
			   			}
			   		
			   	
			   			return str;
			   		}
			   	}
		    			    	
		    ]
		});
	}
	
	
	
	
});
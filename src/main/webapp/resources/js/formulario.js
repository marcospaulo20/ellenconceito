$( document ).ready( function () {
	$('#form-login').validate({
	    rules: {
	        email: {	            
	            required: true,
	            email: true
	        },
	        senha: {
	        	required: true,
	        	minlength: 8
	        }
	    },
	    messages: {
			email: "Por favor insira um endereço de e-mail válido",
			senha: {
				required: "Por favor insira uma senha",
				minlength: "Por favor, insira pelo menos 8 caracteres"
			}
		},	
		errorElement: "em",
		errorPlacement: function ( error, element ) {
			// Add the `help-block` class to the error element
			error.addClass( "form-control-feedback" );

			if ( element.prop( "type" ) === "checkbox" ) {
				error.insertAfter( element.parent( "label" ) );
			} else {
				error.insertAfter( element );
			}
			element.parents( ".col-sm-10" ).addClass( "has-feedback" );
		},
		highlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".col-sm-10" ).addClass( "has-danger" ).removeClass( "has-success" );
		},
		unhighlight: function (element, errorClass, validClass) {
			$( element ).parents( ".col-sm-10" ).addClass( "has-success" ).removeClass( "has-danger" );
		}
	});

	$('#form-cadastro').validate({
	    rules: {
	        usuario: {
	        	required: true,
	        	minlength: 8
	        },
	        email: {	            
	            required: true,
	            email: true
	        }	        
	    },
	    messages: {
	    	usuario: {
				required: "Por favor insira o usuário",
				minlength: "Por favor, insira pelo menos 8 caracteres"
			},
			email: "Por favor insira um endereço de e-mail válido"			
		},	
		errorElement: "em",
		errorPlacement: function ( error, element ) {
			// Add the `help-block` class to the error element
			error.addClass( "form-control-feedback" );

			if ( element.prop( "type" ) === "checkbox" ) {
				error.insertAfter( element.parent( "label" ) );
			} else {
				error.insertAfter( element );
			}
			element.parents( ".col-sm-10" ).addClass( "has-feedback" );			
		},		
		highlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".col-sm-10" ).addClass( "has-danger" ).removeClass( "has-success" );
		},
		unhighlight: function (element, errorClass, validClass) {
			$( element ).parents( ".col-sm-10" ).addClass( "has-success" ).removeClass( "has-danger" );
		}
	});	

	$('#form-cadastro-completo').validate({
		rules: {
	        cpf: {
	        	required: true,
	        	minlength: 12
	        },	        
	        dataNascimento: "required",
	        rua: {
	        	required: true,
	        	minlength: 2,
	        	maxlength: 4
	        },
	        cep: {
	        	required: true,
	        	minlength: 5,
	        	maxlength: 8
	        },
	        numero: "required",
	        rua: "required",
	        complemento: {
	        	required: true,
	        	minlength: 5,
	        	maxlength: 60
	        },	        
	        cidade: "required",
	        bairro: "required",
	        telefone: {
	        	required: true, 
	        	minlength: 12,
	        	maxlength: 13
			},	        	
	        senha: {
	        	required: true,
	        	minlength: 8
	        },
	        confirmarSenha: {
	        	required: true,
	        	minlength: 8,
	        	equalTo: "#senha"	
	        }
	    },
	    messages: {
	    	cpf: {
	    		required: "Por favor insira o CPF",
				minlength: "Por favor, insira pelo menos 12 caracteres",
				maxlength: "Por favor, indique não mais do que 12 caracteres."
	    	},	    	
	    	dataNascimento: "Por favor insira a sua data de nascimento",
	    	uf: {
	    		required: "Por favor insira o UF do seu estado",
	    		minlength: "Por favor, insira pelo menos 2 caracteres",
				maxlength: "Por favor, indique não mais do que 4 caracteres."
	    	},
	    	cep: {
	    		required: "Por favor insira o seu CEP",
	    		minlength: "Por favor, insira pelo menos 5 caracteres",
	    		maxlength: "Por favor, indique não mais do que 8 caracteres."
	    	},
	    	numero: "Por favor insira o numero",
	    	rua: "Por favor selecione uma rua",
	    	complemento: {
	    		required: "Por favor insira o seu complemento",
	    		minlength: "Por favor, insira pelo menos 5 caracteres",
	    		maxlength: "Por favor, indique não mais do que 60 caracteres."
	    	},
	    	cidade: "Por favor insira o nome da sua cidade",
	    	bairro: "Por favor insira o bairro",
	    	telefone: {
	    		required: "Por favor insira o telefone",
	    		minlength: "Por favor, insira pelo menos 12 caracteres",
				maxlength: "Por favor, indique não mais do que 13 caracteres."
			},
	    	senha: {
	    		required: "Por favor insira a senha",
	    		minlength: "Por favor, insira pelo menos 8 caracteres"
	    	},
	    	confirmarSenha: {
	    		required: "Por favor insira a senha",
	    		minlength: "Por favor, insira pelo menos 8 caracteres",
	    		equalTo: "Por favor, indique a mesma senha como acima"
	    	}
	    },
	    errorElement: "div",
			errorPlacement: function ( error, element ) {
				// Add the `help-block` class to the error element
				error.addClass( "form-control-feedback" );

				// Add `has-feedback` class to the parent div.form-group
				// in order to add icons to inputs
				element.parents( ".col-sm-10" ).addClass( "has-feedback" );
				element.parents( ".col-sm-4" ).addClass( "has-feedback" );

				if ( element.prop( "type" ) === "checkbox" ) {
					error.insertAfter( element.parent( "label" ) );
				} else {
					error.insertAfter( element );
				}

				// Add the span element, if doesn't exists, and apply the icon classes to it.
				if ( !element.next( "input" )[ 0 ] ) {					
					$( element ).addClass("form-control-danger");
					// $( "<span class='fa fa-remove form-control-feedback'></span>" ).insertAfter( $( element ) );
				}
			},
			success: function ( label, element ) {
				// Add the span element, if doesn't exists, and apply the icon classes to it.
				if ( !$( element ).next( "span" )[ 0 ] ) {
					$( element ).addClass("form-control-success");					
				}
			},
			highlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".col-sm-10" ).addClass( "has-danger" ).removeClass( "has-success" );
				$( element ).parents( ".col-sm-6" ).addClass( "has-danger" ).removeClass( "has-success" );
				$( element ).parents( ".col-sm-4" ).addClass( "has-danger" ).removeClass( "has-success" );
				$( element ).parents( ".col-sm-3" ).addClass( "has-danger" ).removeClass( "has-success" );
				$( element ).parents( ".col-sm-2" ).addClass( "has-danger" ).removeClass( "has-success" );				
			},
			unhighlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".col-sm-10" ).addClass( "has-success" ).removeClass( "has-danger" );
				$( element ).parents( ".col-sm-6" ).addClass( "has-danger" ).removeClass( "has-success" );
				$( element ).parents( ".col-sm-4" ).addClass( "has-success" ).removeClass( "has-danger" );
				$( element ).parents( ".col-sm-3" ).addClass( "has-success" ).removeClass( "has-danger" );
				$( element ).parents( ".col-sm-2" ).addClass( "has-success" ).removeClass( "has-danger" );				
			}		
	});	
});
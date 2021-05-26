#language:pt

@Loja
Funcionalidade: Validar valor de um produto

@CT01
Esquema do Cenário: Adicionar um item no carrinho e validar valor
	Dado navegador aberto na "<aplicacao>" web
	E "<item>" encontrado
	Quando preencho os dados do item com "<quantidade>", "<tamanho>", "<cor>"
	E adiciono ao carrinho
	E crio uma conta com "<email>", "<nome>", "<sobrenome>", "<senha>", "<endereco>", "<cidade>", "<estado>", "<cep>", "<pais>", "<celular>", "<referencia>"
	E realizo o pagamento via cartao de credito
	Entao visualizo a mensagem de sucesso
	
Exemplos:
	| aplicacao 			 				  | item	| quantidade | tamanho | cor   | email               | nome   | sobrenome   | senha  | endereco  				            | cidade   | estado   | cep   | pais          | celular        | referencia  |
	| http://automationpractice.com/index.php | Blouse 	| 10 		 | S 	   | Black | qa_flavio@email.com | Flavio | Henrique    | 321654 | 297 Rua Francisco Negrao, Agua Verde | New York | Colorado | 22338 | United States | +5541996378855 | Ref. Addres |
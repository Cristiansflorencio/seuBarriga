package br.com.cadastro;

import org.junit.Test;
import br.com.core.Base;
import br.com.pages.AcessarBlouses;
import br.com.pages.AcessoPrincipal;
import br.com.pages.FazendoCadastro;
import br.com.pages.ProsseguindoComCarrinho;
import br.com.pages.FinalizarCompra;

public class CompraTest extends Base{
	
	
	@Test
	public void cadastrarUsuarioComEmailExistente() throws InterruptedException {	
		driver.get("http://automationpractice.com/index.php");
		new AcessoPrincipal(driver).selecionarMenu();
		new AcessarBlouses(driver).SelecionarBlouses();
		new ProsseguindoComCarrinho(driver).SeguindoComCompra();
		new FazendoCadastro(driver).fazendoConta();
		new FinalizarCompra(driver).finalizar();
	}

}
 
package br.edu.univas.main;

public class AppArvoreComputador {
    public static void main(String[] args) throws Exception {
        
        //RAIZ = PRODUTO COMPUTADOR
        Arvore arvore = new Arvore("Computador");


        //CADASTRO DE SUB-PEÇAS
        No cpu = new No ("CPU", 1000f, 1);
        No gpu = new No ("GPU", 2000f, 1);
        No ram = new No ("RAM", 200f, 4);
        No fonte = new No ("Fonte", 400f, 1);
        No hd = new No ("HD", 200f, 2);
        No gabinete = new No("Gabinete", 400f, 1);
        No placamae = new No("Placa-Mãe", 500f, 1);


        arvore.getRaiz().acrescentarFilho(cpu);
        arvore.getRaiz().acrescentarFilho(gpu);
        arvore.getRaiz().acrescentarFilho(ram);
        arvore.getRaiz().acrescentarFilho(hd);
        arvore.getRaiz().acrescentarFilho(fonte);
        arvore.getRaiz().acrescentarFilho(gabinete);
        arvore.getRaiz().acrescentarFilho(placamae);

        
        //FOLHAS - SUBPRODUTOS - COMPONENTES;

        No transistor = new No ("Transistores RAM", 10f, 10);
        No chipRAM = new No ("Chip RAM", 20f, 4);
        No pente = new No ("Pente", 20f, 1);

        No ventoinhaGpu = new No ("Ventoinha GPU", 200f, 1);
        No placa = new No("Placa GPU", 1000f, 1);
        No circuitos = new No("Circuitos", 8f, 100);

        No cooler = new No("Cooler", 200f, 1);
        No chip = new No("Chip", 800f, 1);

        No disco = new No("Disco HD", 150f, 1);
        No plasticoHD = new No("Carcaça HD",50f,1);

        No caixa = new No("Caixa fonte", 200f, 1);
        No cabo = new No("Cabo da fonte", 100f, 1);
        No conectores = new No("Conectores Fonte", 25f, 4);

        No placaCircuitos = new No("Placa de circuitos", 100f, 1);
        No conexoes = new No("Conexões placa-mãe", 50f, 6);
        No chipset = new No("Chipset placa-mãe", 100f, 1);

        No componenteCHIP = new No ("Componente CHIP", 100f, 3);
        No capacitores = new No("Capacitores", 500f, 1);
        chip.acrescentarFilho(componenteCHIP);
        chip.acrescentarFilho(capacitores);

        No nanoComponentes = new No("Nano Componentes", 0.50f, 1000);
        capacitores.acrescentarFilho(nanoComponentes);

        No conexaoUSB = new No ("USB", 10f, 2);
        No conexaoSATA = new No ("SATA", 5f, 2);
        No conexaoAUDIO = new No ("Audio", 5f, 2);
        No conexaoPCI = new No("PCI", 10f, 1);
        conexoes.acrescentarFilho(conexaoUSB);
        conexoes.acrescentarFilho(conexaoSATA);
        conexoes.acrescentarFilho(conexaoAUDIO);
        conexoes.acrescentarFilho(conexaoPCI);

        // MONTAGEM ARVORE
        placamae.acrescentarFilho(placaCircuitos);
        placamae.acrescentarFilho(conexoes);
        placamae.acrescentarFilho(chipset);

        fonte.acrescentarFilho(caixa);
        fonte.acrescentarFilho(cabo);
        fonte.acrescentarFilho(conectores);

        hd.acrescentarFilho(disco);
        hd.acrescentarFilho(plasticoHD);

        ram.acrescentarFilho(transistor);
        ram.acrescentarFilho(chipRAM);
        ram.acrescentarFilho(pente);

        gpu.acrescentarFilho(ventoinhaGpu);
        gpu.acrescentarFilho(placa);
        gpu.acrescentarFilho(circuitos);

        cpu.acrescentarFilho(cooler);
        cpu.acrescentarFilho(chip);
        

        //BUSCANDO O NÓ PELO NOME - POIS NESSE EXEMPLO USEI NOMES DIFERENTES
        No buscado = arvore.getRaiz().buscar("Capacitores");
        if(buscado != null){
            System.out.println("Nó que foi buscado: " +buscado.getNome()+ "   - Valor: "+buscado.getValor()+ "  - Quantidade: "+buscado.getQuantidade());
        }else {
            System.out.println("Não Encontrado");
        }

        buscado = arvore.getRaiz().buscar("Nano Componentes");
        if(buscado != null){
            System.out.println("Nó que foi buscado: " +buscado.getNome()+ "   - Valor: "+buscado.getValor()+ "  - Quantidade: "+buscado.getQuantidade());
        }else {
            System.out.println("Não Encontrado");
        }

        buscado = arvore.getRaiz().buscar("FONTE");
        if(buscado != null){
            System.out.println("Nó que foi buscado: " +buscado.getNome()+ "   - Valor: "+buscado.getValor()+ "  - Quantidade: "+buscado.getQuantidade());
        }else {
            System.out.println("Não Encontrado");
        }


        //SOMA DO VALOR TOTAL DO PRODUTO - COMPUTADOR 
        arvore.getRaiz().valorArvore();
        System.out.println("\n \n \n :::::: VALOR TOTAL DO PRODUTO: "+No.soma);


        arvore.getRaiz().folhas();
        System.out.println("\n \n \n \n \n \n FOLHAS / COMPONENTES - NÓS SEM FILHOS. \n");
        for(No folha : No.folhas){
            System.out.println("Nome: "+folha.getNome());
            System.out.println("Valor: "+folha.getValor());
            System.out.println("Quantidade: "+folha.getQuantidade());
        }

        arvore.getRaiz().componentes();
        System.out.println("\n \n \n \n \n \n TODOS COMPONENTES CADASTRADOS \n");
        for(No folha : No.componentes){
            System.out.println("Nome: "+folha.getNome());
            System.out.println("Valor: "+folha.getValor());
            System.out.println("Quantidade: "+folha.getQuantidade());
        }


    }
}

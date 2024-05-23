<script>
  import { onMount, onDestroy } from 'svelte';
  import { Router, Link } from 'svelte-routing';
  import Jogurt from '../src/routes/post/jogurt.svelte'; // Importuj Jogurt.svelte
  import historycznykalendarz from './routes/post/historyczny-kalendarz.svelte';
  import Navbar from './lib/sections/Navbar.svelte';

  // Ustawienie początkowej zawartości dla posta
  let PostComponent = null;

  // Funkcja do ładowania komponentu w zależności od ścieżki
  const loadComponent = (path) => {
    switch(path) {
      case "/library/jogurt":
        PostComponent = Jogurt;
        break;
      // Możesz dodać obsługę innych ścieżek tutaj
      case "/library/historycznykalendarz":
        PostComponent = historycznykalendarz;
        break;
   
      default:
        PostComponent = null;
    }
  };

  // Użycie onMount, aby sprawdzić ścieżkę podczas montowania komponentu
  onMount(() => {
    loadComponent(window.location.pathname);
  });

  // Użyj Router, aby wyświetlić odpowiedni komponent w zależności od ścieżki
  // Ten fragment pozwala na dynamiczne ładowanie komponentów w zależności od ścieżki
  // Jeśli ścieżka pasuje do któregoś z przypadków, zostanie załadowany odpowiedni komponent
</script>
<body>
<Router>
  {#if PostComponent !== null}
    <Navbar/>

    <PostComponent/>
    
  {:else}
  <Navbar/>
    <p>No content to display</p>
  {/if}
</Router>
 </body>
 <style>
body {
		position:absolute;
		min-height: 100%;
		min-width: 100%;
		background:linear-gradient(to bottom,rgb(2 6 23),rgb(30 41 59));
	}
 </style>
 
<script>
  import { onMount } from 'svelte';
  import Tile from '../lib/layouts/Tile.svelte';
  import Footer from '../lib/sections/Footer.svelte';
  import Navbar from '../lib/sections/Navbar.svelte';
  import { mainColorText, mainColorBorder } from '../stores/ColorStore.js';
  import { fade } from 'svelte/transition';

  mainColorText.set("text-white");
  mainColorBorder.set("border-white");

  let tiles = JSON.parse(localStorage.getItem('tiles')) || [];
  let newTileTitle = '';
  let newTileDescription = '';

  function addTile() {
    if (newTileTitle && newTileDescription) {
      tiles = [...tiles, { title: newTileTitle, description: newTileDescription }];
      localStorage.setItem('tiles', JSON.stringify(tiles));
      newTileTitle = '';
      newTileDescription = '';
    }
  }

  function removeTile(index) {
    tiles = tiles.filter((_, i) => i !== index);
    localStorage.setItem('tiles', JSON.stringify(tiles));
  }
</script>

<style>
  
  .main-container {
    display: flex;
    
  }

  .grid-container {
    width: 50%;
    padding-top: 10vh;
    padding-right: 20px;
    
  }

  .form-container {
    width: 25%;
    padding-top:10vh;
  }
</style>

<Navbar />

<div class="main-container text-3xl font-bold text-white overflow-auto h-[100vh] w-[100vw]">

  <div class="grid-container">
    {#each tiles as { title, description }, index}
      <div transition:fade>
        <Tile {title} {description} />
        <button on:click={() => removeTile(index)} class="delete-button">Delete</button>
      </div>
    {/each}
  </div>

  <div class="form-container">
    <div class="text-white mx-3 mt-3 mb-1">
      <h2>Dodaj nowy kafelek</h2>
      <form on:submit|preventDefault={addTile}>
        <label for="newTileTitle">Tytuł:</label>
        <input bind:value={newTileTitle} id="newTileTitle" required class="text-black" />

        <label for="newTileDescription">Opis:</label>
        <textarea bind:value={newTileDescription} id="newTileDescription" required class="text-black" />

        <button type="submit">Dodaj kafelek</button>
      </form>
    </div>
  </div>
</div>

<Footer />

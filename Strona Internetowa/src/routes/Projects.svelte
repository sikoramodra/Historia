<script>
	import Navbar from './../lib/Navbar.svelte';
	import Footer from '../lib/Footer.svelte';
	import { mainColorText, mainColorBorder } from '../store.js';

    mainColorText.set("text-white");
    mainColorBorder.set("border-white");
</script>

<Navbar />
<div class="text-4xl font-bold h-screen flex items-center justify-center text-white">
    <p>Projects</p>
</div>
<Footer />
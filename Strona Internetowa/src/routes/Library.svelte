<script>
	import Navbar from "../lib/sections/Navbar.svelte";
	import { mainColorBorder, mainColorText } from "../stores/ColorStore.js";
	
	import Footer from "../lib/sections/Footer.svelte";
	
	mainColorText.set("text-white");
	mainColorBorder.set("border-white");

	let hCard = false;
</script>

<div class="bg">
	<div class="as">
		<div class="space-y-4 card-container">
			
		</div>
	</div>
</div>
<Navbar />
<Footer />

<style>
	.as {
		background: linear-gradient(red, black);
		min-height: 100vh;
	}
	.bg {
		background: linear-gradient(red, black);
	}
	@media (min-width: 768px) {
		/* Ustawienia dla większych ekranów */
		.card-container {
			display: flex;
			flex-direction: column-reverse;
		}
	}
	.as {
		display: flex;
		align-items: center;
		justify-content: center;
		font-weight: bold;
		font-family: Montserrat, sans-serif;
		width: 100%;
		min-height: 100vh;
	}
	/* .card {
		background-color: red;
	} */
</style>

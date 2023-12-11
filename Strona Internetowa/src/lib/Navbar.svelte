<script>
	import { Link } from "svelte-routing";
	import { mainColorText, mainColorBorder } from "../store.js";

	let NavColorText;
	let NavColorBorder;

	$: {
		NavColorText = $mainColorText;
		NavColorBorder = $mainColorBorder;
	}
</script>

<nav class="fixed top-0 left-0 right-0 z-[60] px-8 h-20 { NavColorText }">
	<div class="font-semibold text-2xl flex flex-row items-center h-full">
		<div class="w-1/5 pl-8">
			<Link to="/" class="text-left text-5xl px-12 font-bold"><img src="" alt="Home" /></Link> <!-- Logo poziom_ciemne tło_PNG / Logo poziom_jasne tło_PNG -->
		</div>
		<div class="w-3/5 text-left">
			<Link to="/library">Library</Link>
			<Link to="/projects" class="w-3/5 mx-12">Projects</Link>
		</div>
		<div class="w-1/5 text-right">
			<Link to="/search-site" class="border-2 { NavColorBorder } p-2 rounded-lg"
				>Search Site <i class="fa-solid fa-magnifying-glass" /></Link
			>
		</div>
	</div>
</nav>

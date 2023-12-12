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
	<div class="font-semibold sm:text-base md:text-lg lg:text-xl xl:text-2xl 2xl:text-4xl text-sm flex flex-row items-center h-full">
		<div class="w-1/5 min-w-fit sm:pl-6 md:pl-8 pl-4">
			<Link to="/" class="text-left text-2xl sm:text-3xl md:text-4xl lg:text-5xl xl:text-6xl 2xl:text-8xl px-12 font-bold"><img src="" alt="Home" /></Link> <!-- Logo poziom_ciemne tło_PNG / Logo poziom_jasne tło_PNG -->
		</div>
		<div class="w-3/5 min-w-fit">
			<Link to="/library" class="w-1/2 mx-8">Library</Link>
			<Link to="/projects" class="w-1/2">Projects</Link>
		</div>
		<div class="w-1/5 text-right min-w-fit">
			<Link to="/search-site" class="border-2 p-2 rounded-lg { NavColorBorder }"
				>Search Site <i class="fa-solid fa-magnifying-glass" /></Link>
		</div>
	</div>
</nav>

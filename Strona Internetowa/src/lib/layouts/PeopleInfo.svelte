<script>
	export let data;
	export let closePopup;
</script>

<!-- <div class="h-[85%] w-[85%] bg-slate-700 rounded-xl overflow-auto p-4">
    <pre class="text-sm">{JSON.stringify(data, null, 2)}</pre>
</div> -->

<div class="text-center h-[85%] w-[85%] bg-slate-800 rounded-xl overflow-auto p-4 shadow-lg relative">
	<button class="absolute top-4 right-1 text-right text-white text-lg focus:outline-none" on:click={closePopup()}>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
			<path
				d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"
			/>
		</svg></button
	>
	{#if data}
		<h2 class="text-4xl font-bold text-white mb-4">{data.name}</h2>
		<div class="grid grid-cols-1 md:grid-cols-2 gap-y-4">
			<div>
				<p class="text-lg font-semibold text-gray-300 mb-2">Inscription:</p>
				<p class="text-base text-gray-400 mb-4">{data.inscription}</p>

				<p class="text-lg font-semibold text-gray-300 mb-2">Other Names:</p>
				<p class="text-base text-gray-400 mb-4">{data.other_names.join(", ")}</p>

				<p class="text-lg font-semibold text-gray-300 mb-2">Code Names:</p>
				<p class="text-base text-gray-400 mb-4">{data.code_names.join(", ")}</p>
			</div>
			<div>
				<p class="text-lg font-semibold text-gray-300 mb-2">Birth Date:</p>
				<p class="text-base text-gray-400 mb-4">{data.birth_date}</p>

				<p class="text-lg font-semibold text-gray-300 mb-2">Birth Place:</p>
				<p class="text-base text-gray-400 mb-4">{data.birth_place}</p>

				<p class="text-lg font-semibold text-gray-300 mb-2">Death Date:</p>
				<p class="text-base text-gray-400 mb-4">{data.death_date}</p>

				<p class="text-lg font-semibold text-gray-300 mb-2">Death Place:</p>
				<p class="text-base text-gray-400 mb-4">{data.death_place}</p>

				<p class="text-lg font-semibold text-gray-300 mb-2">Grave:</p>
				<p class="text-base text-gray-400 mb-4">{data.grave}</p>

				<p class="text-lg font-semibold text-gray-300 mb-2">Description:</p>
				<p class="text-base text-gray-400 mb-4">{data.description || "Not available"}</p>

				<p class="text-lg font-semibold text-gray-300 mb-2">Sources:</p>
				<p class="text-base text-gray-400 mb-4">{data.sources || "Not available"}</p>
			</div>
		</div>
	{:else}
		<p class="text-2xl font-semibold text-white">No person selected.</p>
	{/if}
</div>

<style>
	::-webkit-scrollbar {
		width: 12px;
	}

	::-webkit-scrollbar-track {
		background-color: transparent;
		border-radius: 32px;
	}

	::-webkit-scrollbar-thumb {
		box-shadow: inset 0 0 6px rgb(31, 41, 55);
		background-color: rgb(31, 41, 55);
		border-radius: 0.7rem;
	}
</style>

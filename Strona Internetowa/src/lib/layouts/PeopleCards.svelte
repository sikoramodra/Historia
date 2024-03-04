<script>
	export let data;

	const birthDateFormatted = `${data.birth_date.substring(8, 10)}.${data.birth_date.substring(5, 7)}.${data.birth_date.substring(0, 4)}`;

	const deathDateFormatted = `${data.death_date.substring(8, 10)}.${data.death_date.substring(5, 7)}.${data.death_date.substring(0, 4)}`;
</script>

<div class="flex flex-col border border-gray-700 shadow-lg p-4 rounded-lg bg-gray-800 text-white h-min">
	<div class="text-center">
		<h1 class="font-bold text-lg lg:text-xl mb-2">{data.name}</h1>
		<div class="border-b border-gray-700 mb-2"></div>
	</div>
	<div class="flex flex-col lg:flex-row justify-between mb-4">
		<div>
			<h2 class="font-semibold text-md lg:text-lg mb-1">Other Names</h2>
			{#if data.other_names.length > 0}
				<div class="mt-2">
					{#each data.other_names.slice(0, 2) as otherName}
						<p class="text-sm lg:text-base">{otherName.length > 15 ? `${otherName.slice(0, 15)}...` : otherName}</p>
					{/each}
					{#if data.other_names.length > 2}
						<p class="text-sm lg:text-base">+ {data.other_names.length - 2} more</p>
					{/if}
				</div>
			{:else}
				<p class="text-sm lg:text-base">No other names</p>
			{/if}
		</div>
		<div class="mt-4 lg:mt-0 lg:ml-4">
			<h2 class="font-semibold text-md lg:text-lg mb-1">Code Names</h2>
			{#if data.code_names.length > 0}
				<div class="mt-2">
					{#each data.code_names.slice(0, 2) as codeName}
						<p class="text-sm lg:text-base">{codeName.length > 15 ? `${codeName.slice(0, 15)}...` : codeName}</p>
					{/each}
					{#if data.code_names.length > 2}
						<p class="text-sm lg:text-base">+ {data.code_names.length - 2} more</p>
					{/if}
				</div>
			{:else}
				<p class="text-sm lg:text-base">No code names</p>
			{/if}
		</div>
	</div>
	<div class="flex flex-col lg:flex-row justify-between mb-4">
		<div>
			<p class="text-gray-300"><span class="font-semibold">Birth Place:</span> {data.birth_place}</p>
			<p class="text-gray-300"><span class="font-semibold">Birth Date:</span> {birthDateFormatted}</p>
		</div>
		<div class="mt-4 lg:mt-0">
			<p class="text-gray-300"><span class="font-semibold">Death Place:</span> {data.death_place}</p>
			<p class="text-gray-300"><span class="font-semibold">Death Date:</span> {deathDateFormatted}</p>
		</div>
	</div>
</div>

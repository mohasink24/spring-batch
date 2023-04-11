package com.izak.projects.springbatch.source;

public class ItemReader {

    /*@Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Value("input/record.csv")
    private Resource inputCsv;

    @Value("file:xml/output.xml")
    private Resource outputXml;

    @Bean
    public ItemReader<Coffee> itemReader()
            throws UnexpectedInputException, ParseException {
        FlatFileItemReader<Coffee> reader = new FlatFileItemReader<Coffee>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        String[] tokens = { "username", "userid", "transactiondate", "amount" };
        tokenizer.setNames(tokens);
        reader.setResource(inputCsv);
        DefaultLineMapper<Coffee> lineMapper =
                new DefaultLineMapper<Coffee>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new RecordFieldSetMapper());
        reader.setLineMapper(lineMapper);
        return reader;
    }

    @Bean
    public ItemProcessor<Coffee, Coffee> itemProcessor() {
        return new CustomItemProcessor();
    }

    @Bean
    public ItemWriter<Coffee> itemWriter(Marshaller marshaller)
            throws MalformedURLException {
        StaxEventItemWriter<Coffee> itemWriter =
                new StaxEventItemWriter<Coffee>();
        itemWriter.setMarshaller(marshaller);
        itemWriter.setRootTagName("transactionRecord");
        itemWriter.setResource(outputXml);
        return itemWriter;
    }

    @Bean
    public Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(new Class[] { Coffee.class });
        return marshaller;
    }

    @Bean
    protected Step step1(ItemReader<Coffee> reader,
                         ItemProcessor<Coffee, Coffee> processor,
                         ItemWriter<Coffee> writer) {
        return steps.get("step1").<Coffee, Coffee> chunk(10)
                .reader(reader).processor(processor).writer(writer).build();
    }

    @Bean(name = "firstBatchJob")
    public Job job(@Qualifier("step1") Step step1) {
        return jobs.get("firstBatchJob").start(step1).build();
    }*/

}

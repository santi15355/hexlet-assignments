# Домашние задания по Java

Этот туториал раскрывает основные темы, необходимые для комфортного обучения на Хекслете:

* [Как учиться эффективно](#как-учиться-эффективно)
* [Настройка окружения](#настройка-окружения)
* [Структура домашних заданий](#структура-домашних-заданий)
* [Пример решения домашнего задания](#решаем-hello-hexlet)
* [Проверка линтером](#проверка-линтером)
* [Как отправить на проверку](#отправляем-на-проверку)

## Как учиться эффективно

Учебные материалы на Хекслете построены таким образом, чтобы студентам не понадобилось ничего гуглить, а темы для самостоятельного изучения даются дополнительными ссылками в теории или практике. Домашние задания также основаны на предыдущих уроках, поэтому если пройденного ранее материала недостаточно для решения задачи — это наша вина. Напишите об этом в канале группы и оповестите куратора. Он передаст это в методический отдел, а мы улучшим описание задачи и расширим теорию.

### Текст домашнего задания

Текст домашнего задания всегда описывает задачу и несколько требований по её решению. Каждая практика - это закрепление пройденной темы теми подходами, которые уже знакомы студенту. В тексте домашнего задания обычно есть *основное* задание и *дополнительное*.

*Дополнительные задания* необходимы, чтобы глубже погрузиться в тему и ориентированы в первую очередь на тех, кому основное задание показалось слишком простым. Старайтесь выполнять основное задание вовремя, а к дополнительным можно возвращаться позже, когда будет время.

### Если вы не знаете что дальше делать

При решении задач нормально испытывать сложности в поиске решения, экспериментировать отлаживать. Этот чек-лист поможет лучше понять задачу:

* Изучите все файлы упражнения. Они дадут представление об архитектуре кода и способах его запуска.
* Запустите тесты. Текст ошибки покажет, что ожидалось и что получилось.
* Используйте [отладочную печать](https://help.hexlet.io/ru/articles/111500-kak-nayti-oshibki-v-kode). Она поможет увидеть результаты выполнения кода по шагам.

Когда вы застряли и **в течение часа** не можете сдвинуться с места, не видите вариантов решения или не можете справиться с ошибкой, поищите в чате вопросы других студентов или создайте напишите вопрос в чат сами. Если вопросы касаются кода, прикрепляйте в тред ссылки, а не куски кода. При составлении вопроса опирайтесь на наш гайд ["Как правильно задавать вопросы"](https://help.hexlet.io/ru/articles/111495-kak-pravilno-zadavat-voprosy).

### Статьи об обучении на Хекслете

* Статья [«Как учиться и справляться с негативными мыслями»](https://guides.hexlet.io/ru/learning)
* Статья [«Ловушки обучения»](https://ru.hexlet.io/blog/posts/traps-learning)
* Статья [«Сложные простые задачи по программированию»](https://ru.hexlet.io/blog/posts/slozhnye-prostye-zadachi-po-programmirovaniyu)
* Урок [«Как эффективно учиться на Хекслете»](https://ru.hexlet.io/courses/introduction_to_programming/lessons/hexlet-flow/theory_unit)
* Вебинар [«Как самостоятельно учиться»](https://www.youtube.com/watch?v=dCYZppVgGww)

## Домашнее задание

### Настройка окружения

Для решения домашних заданий на компьютере должно быть подготовлено рабочее окружения — [установлена](https://github.com/Hexlet/instructions) Java, Gradle и редактор для кода.
Для скачивания и отправки домашних заданий используется утилита [hexlet/cli](https://github.com/Hexlet/cli/blob/main/src/templates/program/README.md).

### Структура домашних заданий

Изучим структуру каталога *exercises* с домашним заданием *Hello, Hexlet!*:

```text
hello-hexlet
├── build.gradle
├── gradlew
├── gradlew.bat
├── Makefile
├── README.md
├── TUTORIAL.md <-- мы здесь
├── presentation.pdf
├── src
│   ├── main
│   │   └── java
│   │       └── exercise
│   │           └── App.java
│   └── test
│       └── java
│           └── exercise
│               └── AppTest.java
```

* на верхнем уровне README содержит текст задачи. Здесь описывается что нужно сделать.
* *src/test/java/exercise* содержит один или несколько файлов тестов для проверки решения. Тесты описывают как должно работать решение. Они являются основными требованиями к коду и дополняют задачу, описанную в README.
* *src/main/java/exercise* содержит один или несколько файлов для решения студента.
* *presentation.pdf* - файл с презентацией, которая была на вебинаре. Иногда презентации обновляются, повторная загрузка упражнения позволит получить свежую версию.

### Решаем "Hello, Hexlet!"

#### Шаг 1: Запустим тесты без готового решения

Используйте Gradle для запуска тестов:

```bash
gradle test
```

Эта команда запустит проверку решения и выдаст ошибку, подобную такой:

```bash
> Task :compileTestJava
/usr/src/app/src/test/java/exercise/AppTest.java:11: error: cannot find symbol
            App.main(null);
            ^
  symbol:   variable App
  location: class AppTest
1 error
```

#### Шаг 2: Пишем решение

Откроем в редакторе кода файл для решения по пути *src/main/java/exercise/App.java*:

```java
package exercise;

// BEGIN


Своё решение нужно размещать между маркерами *BEGIN* и *END*. Разместим там код решения:

```java
package exercise;

// BEGIN

// END
```

Запустим тесты ещё раз:

```bash
gradle test
```

Теперь тесты сообщают, что ожидалась (expected) строка "This is Hexlet!", а был получена (but was) строка "Hello, Hexlet!".

```bash
> Task :test

exercise.AppTest

  Test testMain() FAILED

  org.opentest4j.AssertionFailedError:
  expected: "This is Hexlet!"
  but was : "Hello, Hexlet!"
      at exercise.AppTest.testMain(AppTest.java:13)
```

#### Шаг 3: Изучим тесты

Основной спецификацией к коду выступают тесты. Они раскрывают те детали требований, которые в README могли быть отражены в общих чертах. Откроем файл с тестом *src/test/java/exercise/AppTest.java*:

```java
package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

class AppTest {
    @Test
    void testMain() throws Exception {
        String result = tapSystemOut(() -> {
            App.main(null);
        });
        // здесь происходит сравнение ожидаемой строки с пришедшей
        assertThat(result.trim()).isEqualTo("This is Hexlet!");
    }
}
```

Поправим наше решение и запустим тесты повторно на проверку.

```java
package exercise;

// BEGIN

// END
```

```bash
gradle test

> Task :test

exercise.AppTest

  Test testMain() PASSED

SUCCESS: Executed 1 tests in 632ms


BUILD SUCCESSFUL in 1s
3 actionable tasks: 2 executed, 1 up-to-date
```

Готово, тесты пройдены! Теперь можно сдавать домашнюю работу.

### Проверка линтером

Сейчас домашние задания скачиваются без линтера, чтобы студентам не приходилось загружать много зависимостей в каждом упражнении. Но проверка линтером проходит гитлабе.

Чтобы сделать локально проверку линтером, необходимо на уровне своего каталога с домашними заданиями создать файлы *checkstyle.xml* в каталог *config/checkstyle/* и файл *build.gradle* со следующим содержимым:

build.gradle:

```gradle
plugins {
  id 'checkstyle'
}

repositories {
  mavenCentral()
}

checkstyle {
  toolVersion '8.41'
}

task checkExercises (type: Checkstyle) {
  source 'exercises/'
  include '**/*.java'
  classpath = files()
}
```

config/checkstyle/checkstyle.xml

```xml
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
        "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN"
        "https://checkstyle.org/dtds/configuration_1_3.dtd">

<!--

  Checkstyle configuration that checks the sun coding conventions from:

    - the Java Language Specification at
      https://docs.oracle.com/javase/specs/jls/se11/html/index.html

    - the Sun Code Conventions at https://www.oracle.com/technetwork/java/codeconvtoc-136057.html

    - the Javadoc guidelines at
      https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html

    - the JDK Api documentation https://docs.oracle.com/en/java/javase/11/

    - some best practices

  Checkstyle is very configurable. Be sure to read the documentation at
  https://checkstyle.org (or in your downloaded distribution).

  Most Checks are configurable, be sure to consult the documentation.

  To completely disable a check, just comment it out or delete it from the file.
  To suppress certain violations please review suppression filters.

  Finally, it is worth reading the documentation.

-->

<module name="Checker">
    <!--
        If you set the basedir property below, then all reported file
        names will be relative to the specified directory. See
        https://checkstyle.org/5.x/config.html#Checker

        <property name="basedir" value="${basedir}"/>
    -->
    <property name="severity" value="error"/>

    <property name="fileExtensions" value="java, properties, xml"/>

    <!-- Excludes all 'module-info.java' files              -->
    <!-- See https://checkstyle.org/config_filefilters.html -->
    <module name="BeforeExecutionExclusionFileFilter">
        <property name="fileNamePattern" value="module\-info\.java$"/>
    </module>

    <!-- https://checkstyle.org/config_filters.html#SuppressionFilter -->
    <module name="SuppressionFilter">
        <property name="file" value="${org.checkstyle.sun.suppressionfilter.config}"
                  default="checkstyle-suppressions.xml" />
        <property name="optional" value="true"/>
    </module>

    <!-- Checks that a package-info.java file exists for each package.     -->
    <!-- See https://checkstyle.org/config_javadoc.html#JavadocPackage -->
    <!-- <module name="JavadocPackage"/> -->

    <!-- Checks whether files end with a new line.                        -->
    <!-- See https://checkstyle.org/config_misc.html#NewlineAtEndOfFile -->
    <module name="NewlineAtEndOfFile"/>

    <!-- Checks that property files contain the same keys.         -->
    <!-- See https://checkstyle.org/config_misc.html#Translation -->
    <module name="Translation"/>

    <!-- Checks for Size Violations.                    -->
    <!-- See https://checkstyle.org/config_sizes.html -->
    <module name="FileLength"/>
    <module name="LineLength">
        <property name="fileExtensions" value="java"/>
    </module>

    <!-- Checks for whitespace                               -->
    <!-- See https://checkstyle.org/config_whitespace.html -->
    <module name="FileTabCharacter"/>

    <!-- Miscellaneous other checks.                   -->
    <!-- See https://checkstyle.org/config_misc.html -->
    <module name="RegexpSingleline">
        <property name="format" value="\s+$"/>
        <property name="minimum" value="0"/>
        <property name="maximum" value="0"/>
        <property name="message" value="Line has trailing spaces."/>
    </module>

    <!-- Checks for Headers                                -->
    <!-- See https://checkstyle.org/config_header.html   -->
    <!-- <module name="Header"> -->
    <!--   <property name="headerFile" value="${checkstyle.header.file}"/> -->
    <!--   <property name="fileExtensions" value="java"/> -->
    <!-- </module> -->

    <module name="TreeWalker">

        <!-- Checks for Javadoc comments.                     -->
        <!-- See https://checkstyle.org/config_javadoc.html -->
        <module name="InvalidJavadocPosition"/>
        <module name="JavadocMethod"/>
        <module name="JavadocType"/>
        <!-- <module name="JavadocVariable"/> -->
        <module name="JavadocStyle"/>
        <!-- <module name="MissingJavadocMethod"/> -->

        <!-- Checks for Naming Conventions.                  -->
        <!-- See https://checkstyle.org/config_naming.html -->
        <module name="ConstantName"/>
        <module name="LocalFinalVariableName"/>
        <module name="LocalVariableName"/>
        <module name="MemberName"/>
        <module name="MethodName"/>
        <module name="PackageName"/>
        <module name="ParameterName"/>
        <module name="StaticVariableName"/>
        <module name="TypeName"/>

        <!-- Checks for imports                              -->
        <!-- See https://checkstyle.org/config_import.html -->
        <module name="AvoidStarImport"/>
        <module name="IllegalImport"/> <!-- defaults to sun.* packages -->
        <module name="RedundantImport"/>
        <module name="UnusedImports">
            <property name="processJavadoc" value="false"/>
        </module>

        <!-- Checks for Size Violations.                    -->
        <!-- See https://checkstyle.org/config_sizes.html -->
        <module name="MethodLength"/>
        <module name="ParameterNumber"/>

        <!-- Checks for whitespace                               -->
        <!-- See https://checkstyle.org/config_whitespace.html -->
        <module name="EmptyForIteratorPad"/>
        <module name="GenericWhitespace"/>
        <module name="MethodParamPad"/>
        <module name="NoWhitespaceAfter"/>
        <module name="NoWhitespaceBefore"/>
        <module name="OperatorWrap"/>
        <module name="ParenPad"/>
        <module name="TypecastParenPad"/>
        <module name="WhitespaceAfter"/>
        <module name="WhitespaceAround"/>

        <!-- Modifier Checks                                    -->
        <!-- See https://checkstyle.org/config_modifiers.html -->
        <module name="ModifierOrder"/>
        <module name="RedundantModifier"/>

        <!-- Checks for blocks. You know, those {}'s         -->
        <!-- See https://checkstyle.org/config_blocks.html -->
        <module name="AvoidNestedBlocks"/>
        <module name="EmptyBlock"/>
        <module name="LeftCurly"/>
        <module name="NeedBraces"/>
        <module name="RightCurly"/>

        <!-- Checks for common coding problems               -->
        <!-- See https://checkstyle.org/config_coding.html -->
        <module name="EmptyStatement"/>
        <module name="EqualsHashCode"/>
        <module name="HiddenField"/>
        <module name="IllegalInstantiation"/>
        <module name="InnerAssignment"/>
        <!-- <module name="MagicNumber"/> -->
        <module name="MissingSwitchDefault"/>
        <module name="MultipleVariableDeclarations"/>
        <module name="SimplifyBooleanExpression"/>
        <module name="SimplifyBooleanReturn"/>

        <!-- Checks for class design                         -->
        <!-- See https://checkstyle.org/config_design.html -->
        <module name="DesignForExtension"/>
        <module name="FinalClass"/>
        <!-- <module name="HideUtilityClassConstructor"/> -->
        <module name="InterfaceIsType"/>
        <module name="VisibilityModifier"/>

        <!-- Miscellaneous other checks.                   -->
        <!-- See https://checkstyle.org/config_misc.html -->
        <module name="ArrayTypeStyle"/>
        <!-- <module name="FinalParameters"/> -->
        <!-- <module name="TodoComment"/> -->
        <module name="UpperEll"/>

        <!-- https://checkstyle.org/config_filters.html#SuppressionXpathFilter -->
        <module name="SuppressionXpathFilter">
            <property name="file" value="${org.checkstyle.sun.suppressionxpathfilter.config}"
                      default="checkstyle-xpath-suppressions.xml" />
            <property name="optional" value="true"/>
        </module>

    </module>

</module>
```

Запуск линтера нужно выполнять в каталоге с упражнениями следующей командой:

```bash
gradle checkExercises
```

Пример ошибки линтера:

```bash
~/Hexlet/react-testing/exercises/unit-testing/__tests__/index.test.js
> Task :checkExercises FAILED
[ant:checkstyle] [ERROR] ~/Hexlet/java/exercises/fundamentals/src/main/java/exercise/App.java:6: Line has trailing spaces. [RegexpSingleline]
[ant:checkstyle] [ERROR] ~/Hexlet/java/exercises/fundamentals/src/main/java/exercise/App.java:6:22: '=' is not followed by whitespace. [WhitespaceAround]

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':checkExercises'.
```

Описание ошибок дано на сайте [checkstyle](https://checkstyle.sourceforge.io/checks.html).

### Отправляем на проверку

Используя команду *submit* из [hexlet/cli](https://github.com/Hexlet/cli/blob/main/src/templates/program/README.md), отправляем своё решение в Gitlab. Там оно пройдёт проверку автоматической системой. При её успешно завершении можно запрашивать проверку у своего наставника.

Подробнее этот процесс описан в [статье](https://help.hexlet.io/ru/articles/192894-domasnie-zadaniya).

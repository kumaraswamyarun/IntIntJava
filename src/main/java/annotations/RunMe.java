package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//public @ interface RunMe {
//@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})

// We might "look for" an annotation in any of 4 ways,
// three different points in the code lifecycle
// Human looking at source (annotations can be documents)
// Compiler working on the source (you can create a
// "plug-in" for the compiler and cause code generation
// or modifcation, or other behaviour during compilation
// (good luck with that :)
//
// Examine the generated classfiles--modify them, or generate
// documentation, or whatever? Create new code / classes
// (good luck with that :) -- AspectJ does code rewriting
//
// Examine java.lang.Class objects in memory at runtime
// :)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunMe {
}
